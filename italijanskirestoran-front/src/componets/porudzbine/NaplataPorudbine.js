import React from 'react';
import ItalijanskiRestoranAxios from '../../apis/ItalijanskiRestoranAxios';
import {Button, Form, Table} from "react-bootstrap";

class NaplataPorudzbine extends React.Component {

    constructor(props){
        super(props);

        

        this.state = {
            porudzbina:{stoId: -1, placeno: "", ukupnacena: 0.0},
            ukupnacena: 0.0,
            porudzbinaId: -1,
            stavke: [],
            hrana: [],
            prilozi: [],
            pica: []}
    }

    componentDidMount(){
        this.getPorudzbinaById(this.props.match.params.id);
        this.getHrana();
        this.getPica();
       
        this.getPrilog();
        this.getStavke();
       
    }

    getPorudzbinaById(porudzbinaId){
        ItalijanskiRestoranAxios.get('/porudzbine/' + porudzbinaId)
        .then(res => {
           console.log("proba prva");
            this.setState({porudzbinaId: res.data.id});
            this.setState({ukupnacena: res.data.ukupnacena})
            console.log("proba druga");
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Greska! Probajte ponovo!');
         });
    }

    async getHrana(){
        try{
            let result = await ItalijanskiRestoranAxios.get("/hrana");
            let hrana = result.data;
            this.setState({hrana: hrana});
            console.log("test hrana");
        }catch(error){
            console.log(error);
            alert("Greska pri pribavljanju hrane");
        }
    }

    async getPrilog(){
        try{
            let result = await ItalijanskiRestoranAxios.get("/prilozi");
            let prilozi = result.data;
            this.setState({prilozi: prilozi});
            console.log("test prilog");
        }catch(error){
            console.log(error);
            alert("Greska pri pribavljanju priloga");
        }
    }

    async getPica(){
        try{
            let result = await ItalijanskiRestoranAxios.get("/pica");
            let pica = result.data;
            this.setState({pica: pica});
            console.log("test pica");
        }catch(error){
            console.log(error);
            alert("Greska pri pribavljanju pica");
        }
    }

    getStavke(){
        
        ItalijanskiRestoranAxios.get('/stavke?id=' + this.props.match.params.id)
        .then(res => {
            // handle success
            console.log(res);
            this.setState({stavke: res.data});
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Error occured please try again!');
        });
    }

    renderStavke(){
        return this.state.stavke.map((stavka) =>{
            return(
                <tr key={stavka.id}>

                    <td>{stavka.hranaDTO.naziv}</td>
                    <td>{stavka.prilogDTO.naziv}</td>
                    <td>{stavka.piceDTO.naziv}</td>
                </tr>
            )
        })
    }

    getCena(){
        return this.state.ukupnacena;
    }

    getCurrentTime() {
        var date = new Date();
        var strArray=['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        var d = date.getDate();
        var m = strArray[date.getMonth()];
        var y = date.getFullYear();
        var h = date.getHours();
        var min = date.getMinutes();
        return '' + (d <= 9 ? '0' + d : d) + '-' + m + '-' + y + " " + h + ":" + min;
    }


    render(){
        return(
            <div>
                <h1>Racun za porudzbinu broj {this.props.match.params.id}</h1>
                <Table style={{marginTop:5}}>
                        <thead>
                            <tr>
                                <th>Hrana</th>
                                <th>Prilog</th>
                                <th>Pice</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderStavke()}
                        </tbody>
                    </Table>
                <h2>Ukupna cena: {this.getCena()} RSD</h2>
                <br/>
                <label>Datum racuna: {this.getCurrentTime()}</label> <br/> 
            </div>
        )
    }
}

export default NaplataPorudzbine;