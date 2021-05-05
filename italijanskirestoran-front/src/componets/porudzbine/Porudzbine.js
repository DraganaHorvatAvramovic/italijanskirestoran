import React from 'react';
import ItalijanskiRestoranAxios from './../../apis/ItalijanskiRestoranAxios';
import {Button, Form, Table} from "react-bootstrap";

class Porudzbine extends React.Component {

    constructor(props){
        super(props);

        this.state = {
            porudzbine: [],
            stolovi: [],
            search: {stoId: -1},
            pageNo: 0,
            totalPages: 0
        }
    }
    componentDidMount(){
        this.getPorudzbine();
        this.getStolovi();
    }

    async getStolovi(){
        try{
            let result = await ItalijanskiRestoranAxios.get("/stolovi");
            let stolovi = result.data;
            this.setState({stolovi: stolovi});
            console.log("test1");
        }catch(error){
            console.log(error);
            alert("Greska pri pribavljanju stolova");
        }
    }

    getPorudzbine(){
        let config = {
            params: {
                pageNo: this.state.pageNo
            },
        }
        if(this.state.search.stoId != -1){
            config.params.stoId = this.state.search.stoId;
        }
        ItalijanskiRestoranAxios.get('/porudzbine', config)
            .then(res => {
                console.log(res);
                this.setState({
                    porudzbine: res.data, 
                    totalPages: res.headers["total-pages"]
                 });
           })
           .catch(error => {
               // handle error
               console.log(error);
               alert('Error occured please try again!');
           });
    }

    goToStavke(porudzbinaId){
        this.props.history.push('/porudzbine/stavke/' + porudzbinaId);
    }

    deleteFromState(porudzbinaId) {
        var porudzbine = this.state.porudzbine;
        porudzbine.forEach((element, index) => {
            if (element.id === porudzbinaId) {
                porudzbine.splice(index, 1);
                this.setState({porudzbine: porudzbine});
            }
        });
    }

    delete(porudzbinaId) {
        ItalijanskiRestoranAxios.delete('/porudzbine/' + porudzbinaId)
        .then(res => {
            // handle success
            console.log(res);
            alert('Porudzbina je uspesno obrisana!');
            this.deleteFromState(porudzbinaId); // ili refresh page-a window.location.reload();
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Greska prilikom brisanja!');
         });
    }

    goToNaplati(porudzbinaId){
        //this.props.history.push('/porudzbine/naplata/' + porudzbinaId);
        ItalijanskiRestoranAxios.put('/porudzbine/' + porudzbinaId, {})
        .then(res => {
            // handle success
            console.log(res);
            alert('Porudzbina je uspesno naplacena!');
            this.props.history.push('/porudzbine/naplataporudzbine/' + porudzbinaId);
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Porudzbina je vec naplacena!');
         });
    }

    renderPorudzbine(){
        return this.state.porudzbine.map((porudzbina) => {
            return(
                <tr key={porudzbina.id}>
                    <td>{porudzbina.stoDTO.naziv}</td>
                    <td>{porudzbina.placeno}</td>
                    <td><Button variant="danger" onClick={() => this.goToStavke(porudzbina.id)}>Stavke</Button></td>
                    <td><Button variant="warning" onClick={() => this.goToNaplati(porudzbina.id)}>Napalati racun</Button></td>
                    <td><Button variant="danger" onClick={() => this.delete(porudzbina.id)}>Delete</Button></td>
                </tr>
            )
        })
    }

    doSearch(){
        this.getPorudzbine();
    }

    searchValueInputChange(event) {
        let control = event.target;
    
        let name = control.name;
        let value = control.value;
    
        let search = this.state.search;
        search[name] = value;
    
        this.setState({ search: search });
    }

    goToAdd(){
        this.props.history.push('/porudzbine/add')
    }

    render(){
        return(
            <div>
                <h1>Porudzbine</h1>
                <div>
                    <Button onClick={() => this.goToAdd() }>Dodaj</Button>
                    <br/>
                    <Form style={{marginTop:35}}>
                        <Form.Group>
                            <Form.Label>Sto</Form.Label>
                            <Form.Control name="stoId" as="select" value={this.state.search.stoId}  onChange={(e) => this.searchValueInputChange(e)}>
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
                        <Button onClick={() => this.doSearch()}>Pretraga</Button>
                    </Form>
                    <Table style={{marginTop:5}}>
                        <thead>
                            <tr>
                                <th>Sto</th>
                                <th>Placeno</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderPorudzbine()}
                        </tbody>
                    </Table>
                    <div><Button disabled={this.state.pageNo==0} onClick={() => this.getPorudzbine(this.state.pageNo= this.state.pageNo-1)} >Previous</Button>
                    <Button disabled={this.state.pageNo==this.state.totalPages-1} onClick={() =>  this.getPorudzbine(this.state.pageNo= this.state.pageNo+1)}>Next</Button></div>
                </div>
            </div>
        )
    }
}

export default Porudzbine;