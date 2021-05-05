import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Form} from "react-bootstrap";

class AddPice extends React.Component{

    constructor(props){
        super(props);

        let pice = {
            naziv: "",
            cena: 0.0,
            zapremina: 0.0
        }
        this.state = {pice: pice}
    }

    create(){
        var params = {
            'naziv' : this.state.naziv,
            'cena' : this.state.cena,
            'zapremina' : this.state.zapremina
        };

        ItalijanskiRestoranAxios.post('/pica', params)
            .then(res => {
                console.log(res);
                alert('Pice je uspesno dodato!');
                this.props.history.push('/pica');
            })
            .catch(error => {
                console.log(error);
                alert('Greska prilikom dodavanja pica!')
            })
    }
    

    valueNazivChange = event => {
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

    valueZapreminaChange = event => {
        console.log(event.target.value);

        const { name, value } = event.target;
        console.log(name + ", " + value);

        this.setState((state, props) => ({
            zapremina: value
        }));
    }

    render(){
        return(
            <div>
                <h1>Dodavanje Novog pica</h1>
                <Form style={{marginTop:35}}>
                    <Form.Group>
                        <Form.Label>Naziv</Form.Label>
                        <Form.Control onChange={(event) => this.valueNazivChange(event)}
                        name="naziv" value={this.state.naziv} as="input"
                        ></Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Cena</Form.Label>
                        <Form.Control onChange={(event) => this.valueCenaChange(event)}
                        name="cena" value={this.state.cena} as="input"
                        ></Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Zapremina</Form.Label>
                        <Form.Control onChange={(event) => this.valueZapreminaChange(event)}
                        name="zapremina" value={this.state.zapremina} as="input"
                        ></Form.Control>
                        <Button variant="primary" onClick={(event) =>{this.create(event);}}>Dodaj</Button>
                    </Form.Group>
                </Form>
            </div>
        )
    }
}

export default AddPice;