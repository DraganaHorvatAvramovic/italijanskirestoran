import React from 'react';
import ItalijanskiRestoranAxios from '../../apis/ItalijanskiRestoranAxios';
import {Button, Form, Table} from "react-bootstrap";

class AddStavke extends React.Component {

    constructor(props){
        super(props);

        let stavka = {
            porudzbina: {porudbinaId: -1, stoId: -1, placeno: "nije placeno"},
            hrana: {hranaId: -1, naziv: "", cena: 0.0},
            prilog: {prilogId: -1, naziv: "", cena: 0.0},
            pice: {piceId:-1, naziv: "", cena: 0.0, zapremina: 0.0}
        }

        this.state = {stavka: stavka, porudzbine: [], hrane: [], prilozi: [], pica: [], porudzbinaId: -1}
    }

    componentDidMount(){
        this.getPorudzbinaById(this.props.match.params.id);
        this.getHrana();
        this.getPica();
       
        this.getPrilog();
        this.getStavke();
        this.getPorudzbina();
       
    }

    getPorudzbinaById(porudzbinaId){
        ItalijanskiRestoranAxios.get('/porudzbine/' + porudzbinaId)
        .then(res => {
           console.log("proba prva");
            this.setState({porudzbinaId: res.data.id});
            let porudzbina = res.data;
            this.setState({porudzbina: porudzbina})
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
            let hrane = result.data;
            this.setState({hrane: hrane});
            console.log("test hrana!!!");
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

    getPorudzbina(){
        ItalijanskiRestoranAxios.get('/porudzbine/sve')
            .then(res => {
                // handle success
                console.log(res);
                this.setState({porudzbine: res.data});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });

    }

    porudzbinaInputChange(e){
        // console.log(e);

        let porudzbinaId = e.target.value;
        
        let porudzbina = this.state.porudzbine.find((porudzbina) => porudzbina.id == porudzbinaId);

        let stavka = this.state.stavka;
        stavka.porudzbina = porudzbina;

        this.setState({stavka: stavka});
    }

   

    hranaInputChange(event) {
        let hranaid = event.target.value;
        let hrana = this.state.hrane.find((hrana) => hrana.id == hranaid);
        let stavka = this.state.stavka;
        stavka.hrana =  hrana;
               
    
        this.setState({ stavka: stavka });
    }

    prilogInputChange(event) {
        let prilogId = event.target.value;
        
        let prilog = this.state.prilozi.find((prilog) => prilog.id == prilogId);
        let stavka = this.state.stavka;
        stavka.prilog =  prilog;
        
    
        this.setState({ stavka: stavka });
    }

    piceInputChange(event) {
        let piceId = event.target.value;
        let pice = this.state.pica.find((pice) => pice.id == piceId);
        let stavka = this.state.stavka;
        stavka.pice =  pice;
        
    
        this.setState({ stavka: stavka });
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
    
    async create(e) {

        e.preventDefault();
        try {

            let stavka = this.state.stavka;
            let stavkaDTO = {
                porudzbinaDTO: stavka.porudzbina,
                hranaDTO: stavka.hrana,
                prilogDTO: stavka.prilog,
                piceDTO: stavka.pice
            }
             let response = await ItalijanskiRestoranAxios.post('/stavke?id=' + this.props.match.params.id, stavkaDTO);
            
             this.props.history.push('/porudzbine/stavke/' + this.props.match.params.id);     
        } catch (error) {
            alert("Nije uspelo dodavanje. Porudzbina mora imati isti id!");
        }
            
    }
    

    render(){
        return (
            <div>
                <h1>Dodavanje nove stavke</h1>
                <h1>Porudzbina: {this.props.match.params.id}</h1>
                <Form style={{marginTop:35}}>
                <Form.Group>
                        <Form.Label>Porudzbina</Form.Label>
                        <Form.Control  onChange={event => this.porudzbinaInputChange(event)}
                         name="porudzbinaId"
                         value={this.state.stavka.porudzbina.porudbinaId}
                         as="select">
                                    <option value={-1}></option>
                                        {this.state.porudzbine.map((porudzbina) => {
                                     return (
                                    <option value={porudzbina.id} key={porudzbina.id}>
                                        {porudzbina.id}
                                     </option>
                                 );
                                 })}
                                </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Hrana</Form.Label>
                        <Form.Control  onChange={(e) => this.hranaInputChange(e)}
                         name="hranaId"
                         value={this.state.stavka.hrana.hranaId}
                         as="select">
                                    <option value={-1}></option>
                                        {this.state.hrane.map((hrana) => {
                                     return (
                                    <option value={hrana.id} key={hrana.id}>
                                        {hrana.naziv}
                                     </option>
                                 );
                                 })}
                                </Form.Control>
                    </Form.Group>
                    <Form.Group>
                            <Form.Label>Prilog</Form.Label>
                                <Form.Control  onChange={(e) => this.prilogInputChange(e)}
                                name="prilogId"
                                value={this.state.stavka.prilog.prilogId}
                                as="select">
                                    <option value={-1}></option>
                                        {this.state.prilozi.map((prilog) => {
                                     return (
                                    <option value={prilog.id} key={prilog.id}>
                                        {prilog.naziv}
                                     </option>
                                 );
                                 })}
                                </Form.Control>
                    </Form.Group>
                    <Form.Group>
                            <Form.Label>Pice</Form.Label>
                                <Form.Control  onChange={(e) => this.piceInputChange(e)}
                                name="piceId"
                                value={this.state.stavka.pice.piceId}
                                as="select">
                                    <option value={-1}></option>
                                        {this.state.pica.map((pice) => {
                                     return (
                                    <option value={pice.id} key={pice.id}>
                                        {pice.naziv}
                                     </option>
                                 );
                                 })}
                                </Form.Control>
                    </Form.Group>
                    <Button variant="primary" onClick={(event)=>{this.create(event);}}>Dodaj</Button>
                </Form>
            </div>
        )
    }
}

export default AddStavke;