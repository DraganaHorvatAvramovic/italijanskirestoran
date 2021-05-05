import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Form} from "react-bootstrap";

class EditPica extends React.Component {

    constructor(props){
        super(props);

        this.state = {piceId: -1, naziv: '', cena: 0.0, zapremina: 0.0}
    }

    componentDidMount(){
        this.getPiceById(this.props.match.params.id);
    }

    getPiceById(piceId){
        ItalijanskiRestoranAxios.get('/pica/' + piceId)
            .then(res => {
                console.log(res);
                this.setState({piceId: res.data.id, naziv: res.data.naziv, cena: res.data.cena, zapremina: res.data.zapremina});
            })
            .catch(error => {
                console.log(error);
                alert('Greska! Probajte ponovo!');
            });
    }

    valueCenaChange = event => {
        console.log(event.target.value);

        const { name, value} = event.target;
        console.log(name + ", " + value);

        this.setState((state, props) => ({
            cena: value
        }));
    }
    valueNazivChange = event => {
        console.log(event.target.value);

        const { name, value} = event.target;
        console.log(name + ", " + value);

        this.setState((state, props) => ({
            naziv: value
        }));
    }

    valueZapreminaChange = event => {
        console.log(event.target.value);

        const { name, value} = event.target;
        console.log(name + ", " + value);

        this.setState((state, props) => ({
            zapremina: value
        }));
    }

    doEdit(){
        var params = {
            'id' : this.state.piceId,
            'naziv' : this.state.naziv,
            'cena' : this.state.cena,
            'zapremina' : this.state.zapremina
        };

        ItalijanskiRestoranAxios.put('/pica/' + this.state.piceId, params)
            .then(res => {
                console.log(res);
                alert('Podaci o picu su uspesno izmenjeni!');
                this.props.history.push('/pica');
            })
            .catch(error => {
                console.log(error);
                alert('Greska prilikom izmene!')
            });
    }

    render(){
        return(
            <div>
                <h1>Izmena podataka o picu</h1>
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
                    </Form.Group>
                    <Button variant="primary" onClick={() => this.doEdit()}>Izmeni</Button>
                </Form>
            </div>
        )
    }
}

export default EditPica;