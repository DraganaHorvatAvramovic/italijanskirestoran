import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Table} from "react-bootstrap";

class Hrana extends React.Component {

    constructor(props){
        super(props);

        this.state = { hrana: []}
    }

    componentDidMount(){
        this.getHrana();
    }

    getHrana(){
        ItalijanskiRestoranAxios.get('/hrana')
            .then(res => {
                // handle success
                console.log(res);
                this.setState({hrana: res.data});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });

    }

    deleteFromState(hranaId) {
        var hrana = this.state.hrana;
        hrana.forEach((element, index) => {
            if (element.id === hranaId) {
                hrana.splice(index, 1);
                this.setState({hrana: hrana});
            }
        });
    }

    delete(hranaId) {
        ItalijanskiRestoranAxios.delete('/hrana/' + hranaId)
        .then(res => {
            // handle success
            console.log(res);
            alert('Hrana je uspesno obrisana!');
            this.deleteFromState(hranaId); // ili refresh page-a window.location.reload();
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Greska prilikom brisanja!');
         });
    }

    goToEdit(hranaId){
        this.props.history.push('/hrana/edit/'+ hranaId); 
    }

    goToAdd(){
        this.props.history.push('/hrana/add');
    }

    renderHrana(){
        return this.state.hrana.map((hrana) =>{
            return(
                <tr key={hrana.id}>
                    <td>{hrana.naziv}</td>
                    <td>{hrana.cena}</td>
                    <td><Button variant="warning" onClick={() => this.goToEdit(hrana.id)}>Edit</Button></td>
                  <td><Button variant="danger" onClick={() => this.delete(hrana.id)}>Delete</Button></td>
                </tr>
            )
        })
    }

    render(){
        return(
            <div>
                <h1>Hrana</h1>
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
                        {this.renderHrana()}
                    </tbody>
                </Table>
                </div>
            </div>
        )
    }

}

export default Hrana;