import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Form} from "react-bootstrap";

class AddPorudzbina extends React.Component {

    constructor(props){
        super(props);

        let porudzbina = {
            sto: {stoId:-1, naziv: ""}, 
            placeno: 'nije placeno'
        }

        this.state = {porudzbina: porudzbina, stolovi: []}
    }

    componentDidMount(){
        this.getStolovi();
    }

    async getStolovi(){
        try{
            let result = await ItalijanskiRestoranAxios.get("/stolovi");
            let stolovi = result.data;
            this.setState({stolovi: stolovi});
            console.log("prikaz stolova");
        }catch(error){
            console.log(error);
            alert("Greska pri pribavljanju stolova!");
        }
    }
    
    // stoOnChange(event){
    //     let control = event.target;
    
    //     let name = control.name;
    //     let value = control.value;
    
    //     let stolovi = this.state.stolovi;
    //     stolovi[name] = value;
    
    //     this.setState({ stolovi: stolovi });
    // }

    stoOnChange(event) {
        let stoId = event.target.value;
        let sto = this.state.stolovi.find((sto) => sto.id == stoId);
        let porudzbina = this.state.porudzbina;
        porudzbina.sto =  sto;
        
    
        this.setState({ porudzbina: porudzbina });
    }

    create() {
        var params = {
            'stoDTO': this.state.porudzbina.sto,
            'placeno': this.state.porudzbina.placeno
        };

        ItalijanskiRestoranAxios.post('/porudzbine', params)
        .then(res => {
            // handle success
            console.log(res);
           
            alert('Porudzbina je uspesno dodata!');
            this.props.history.push('/porudzbine');
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Prethodna porudzbina za zeljeni sto nije naplacena!');
            this.props.history.push('/porudzbine');
         });
    }


    render(){
        return(
            <div>
                <h1>Dodavanje porudzbine</h1>
                <Form style={{marginTop:35}}>
                <Form.Group>
                            <Form.Label>Sto</Form.Label>
                            <Form.Control name="stoId" as="select" value={this.state.porudzbina.sto.stoId}  onChange={(e) => this.stoOnChange(e)}>
                                    <option value={-1}></option>
                                        {this.state.stolovi.map((sto) => {
                                     return (
                                    <option value={sto.id} key={sto.id}>
                                        {sto.naziv}
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

export default AddPorudzbina;