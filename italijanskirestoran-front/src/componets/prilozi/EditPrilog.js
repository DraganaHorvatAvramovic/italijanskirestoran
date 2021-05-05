import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Form} from "react-bootstrap";

class EditPrilog extends React.Component {

    constructor(props){
        super(props);

        this.state = {prilogId: -1, naziv: '', cena: 0.0}
    }

    componentDidMount(){
        this.getPrilogById(this.props.match.params.id);
    }

    getPrilogById(prilogId){
        ItalijanskiRestoranAxios.get('/prilozi/' + prilogId)
        .then(res => {
            // handle success
            console.log(res);
            this.setState({prilogId: res.data.id, naziv: res.data.naziv, cena: res.data.cena});
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Greska! Probajte ponovo!');
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

    doEdit() {
        var params = {
            'id': this.state.prilogId,
            'naziv': this.state.naziv,
            'cena': this.state.cena
        };

        ItalijanskiRestoranAxios.put('/prilozi/' + this.state.prilogId, params)
        .then(res => {
            // handle success
            console.log(res);
            alert('Podaci o prilogu su uspesno izmenjeni!');
            this.props.history.push('/prilozi');
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Greska prilikom izmene!');
         });
    }


    render(){
        return(
            <div>
                <h1>Izmena podataka o prilogu</h1>
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
                    <Button variant="primary" onClick={() => this.doEdit()}>Izmeni</Button>
                </Form>
            </div>
        );
    }
}

export default EditPrilog;