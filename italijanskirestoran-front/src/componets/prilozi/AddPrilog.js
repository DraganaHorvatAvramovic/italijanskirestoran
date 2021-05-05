import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Form} from "react-bootstrap";

class AddPrilog extends React.Component {

    constructor(props){
        super(props);

        let prilog = {
            naziv: "",
            cena: 0.0
        }
        this.state = {prilog: prilog}
    }

    create() {
        var params = {
            'naziv': this.state.naziv,
            'cena': this.state.cena
        };

        ItalijanskiRestoranAxios.post('/prilozi', params)
        .then(res => {
            // handle success
            console.log(res);
           
            alert('Prilog je uspesno dodat!');
            this.props.history.push('/prilozi');
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Greska prilikom dodavanje priloga!');
         });
    }

    valueImeChange = event => {
        console.log(event.target.value);

        const { name, value } = event.target;
        console.log(name + ", " + value);

        this.setState((state, props) => ({
            naziv: value
        }));
    }

    valueCenaChange = event => {
        console.log(event.target.value);

        const { name, value } = event.target;
        console.log(name + ", " + value);

        this.setState((state, props) => ({
            cena: value
        }));
    }

    render(){
        return(
            <div>
                <h1>Dodavanje novog priloga</h1>
                <Form style={{marginTop:35}}>
                    <Form.Group>
                        <Form.Label>Naziv</Form.Label>
                        <Form.Control onChange={(event) => this.valueImeChange(event)}
                         name="naziv" value={this.state.naziv} as="input"
                         ></Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Cena</Form.Label>
                        <Form.Control onChange={(event) => this.valueCenaChange(event)}
                         name="cena" value={this.state.cena} as="input"
                         ></Form.Control>
                    </Form.Group>
                    <Button variant="primary" onClick={(event)=>{this.create(event);}}>Dodaj</Button>
                </Form>
            </div>
        )
    }

}

export default AddPrilog;