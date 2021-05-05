import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Table} from "react-bootstrap";

class Prilozi extends React.Component{

    constructor(props){
        super(props);

        this.state = { prilozi: []}
    }

    componentDidMount(){
        this.getPrilozi();
    }

    getPrilozi(){
        ItalijanskiRestoranAxios.get('/prilozi')
            .then(res => {
                // handle success
                console.log(res);
                this.setState({prilozi: res.data});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });

    }

    deleteFromState(prilogId) {
        var prilozi = this.state.prilozi;
        prilozi.forEach((element, index) => {
            if (element.id === prilogId) {
                prilozi.splice(index, 1);
                this.setState({prilozi: prilozi});
            }
        });
    }

    delete(prilogId) {
        ItalijanskiRestoranAxios.delete('/prilozi/' + prilogId)
        .then(res => {
            // handle success
            console.log(res);
            alert('Prilog je uspesno obrisan!');
            this.deleteFromState(prilogId); // ili refresh page-a window.location.reload();
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Greska prilikom brisanja!');
         });
    }

    goToEdit(prilogId){
        this.props.history.push('/prilozi/edit/'+ prilogId); 
    }

    goToAdd(){
        this.props.history.push('/prilozi/add');
    }

    renderPrilozi(){
        return this.state.prilozi.map((prilog) =>{
            return(
                <tr key={prilog.id}>
                    <td>{prilog.naziv}</td>
                    <td>{prilog.cena}</td>
                    <td><Button variant="warning" onClick={() => this.goToEdit(prilog.id)}>Edit</Button></td>
                  <td><Button variant="danger" onClick={() => this.delete(prilog.id)}>Delete</Button></td>
                </tr>
            )
        })
    }

    render(){
        return(
            <div>
                <h1>Prilozi</h1>
                <div>
                <Button onClick={() => this.goToAdd() }>Dodaj</Button>
                <br/>
                <Table style={{marginTop:5}}>
                    <thead>
                        <tr>
                            <th>Naziv</th>
                            <th>Cena</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.renderPrilozi()}
                    </tbody>
                </Table>
                </div>
            </div>
        )
    }
}

export default Prilozi;