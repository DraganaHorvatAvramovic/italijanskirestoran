import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Table} from "react-bootstrap";

class Pica extends React.Component {

    constructor(props){
        super(props);

        this.state = {pica: []}
    }

    componentDidMount(){
        this.getPica();
    }

    getPica(){
        ItalijanskiRestoranAxios.get('/pica')
            .then(res => {
                console.log(res);
                this.setState({pica: res.data});
            })
            .catch(error => {
                console.log(error);
                alert('Greska u povezivanju sa back-om')
            });
    }

    deleteFromState(piceId){
        var pica = this.state.pica;
        pica.forEach((element, index) => {
            if(element.id === piceId){
                pica.splice(index, 1);
                this.setState({pica: pica});
            }
        });
    }

    delete(piceId) {

        ItalijanskiRestoranAxios.delete('/pica/' + piceId)
            .then(res => {
                console.log(res);
                alert('Pice je uspesno obrisano!');
                this.deleteFromState(piceId);
            })
            .catch(error => {
                console.log(error);
                alert('Greska prilikom brisanja!');
            });
    }

    goToEdit(piceId){
        this.props.history.push('/pica/edit/' + piceId);
    }

    goToAdd(){
        this.props.history.push('/pica/add');
    }

    renderPica(){
        return this.state.pica.map((pice) =>{
            return(
                <tr key={pice.id}>
                    <td>{pice.naziv}</td>
                    <td>{pice.cena}</td>
                    <td>{pice.zapremina}</td>
                    <td><Button variant="warning" onClick={() => this.goToEdit(pice.id)}>Edit</Button></td>
                    <td><Button variant="danger" onClick={() => this.delete(pice.id)}>Delete</Button></td>
                </tr>
            )
        })
    }

    render(){
        return(
            <div>
                <h1>Pica</h1>
                <div>
                    <Button onClick={() => this.goToAdd() }>Dodaj</Button>
                    <br/>
                    <Table style={{marginTop:5}}>
                        <thead>
                            <tr>
                                <th>Naziv</th>
                                <th>Cena</th>
                                <th>Zapremina</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderPica()}
                        </tbody>
                    </Table>
                </div>
            </div>
        )
    }


}

export default Pica;