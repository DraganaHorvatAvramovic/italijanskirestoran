import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, HashRouter as Router, Switch } from 'react-router-dom';
import {Container, Button, Navbar, Nav} from "react-bootstrap"
import Home from './componets/Home';
import NotFound from './componets/NotFound';
import Hrana from './componets/hrana/Hrana';
import EditHrana from './componets/hrana/EditHrana';
import AddHrana from './componets/hrana/AddHrana';
import Prilozi from './componets/prilozi/Prilozi';
import EditPrilog from './componets/prilozi/EditPrilog';
import AddPrilog from './componets/prilozi/AddPrilog';
import Pica from './componets/pica/Pica';
import EditPica from './componets/pica/EditPica';
import AddPice from './componets/pica/AddPica';
import Porudzbine from './componets/porudzbine/Porudzbine';
import Stavke from './componets/porudzbine/Stavke';
import AddStavke from './componets/porudzbine/AddStavke';
import AddPorudzbina from './componets/porudzbine/AddPorudzbina';
import NaplataPorudzbine from './componets/porudzbine/NaplataPorudbine';

class App extends React.Component {

    render(){
        return (
            <div>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                    <Navbar.Brand as={Link} to="/">Home</Navbar.Brand>
                    <Nav>
                    <Nav.Link as={Link} to="/hrana">Hrana</Nav.Link>
                    <Nav.Link as={Link} to="/prilozi">Prilozi</Nav.Link>
                    <Nav.Link as={Link} to="/pica">Pica</Nav.Link>
                    <Nav.Link as={Link} to="/porudzbine">Porudzbine</Nav.Link>
                    </Nav>   
                    </Navbar>
                    <Container style={{paddingTop:"25px"}}>
                        <Switch>
                             <Route exact path="/" component={Home} />
                             <Route exact path="/hrana" component={Hrana} />
                             <Route exact path="/hrana/edit/:id" component={EditHrana} />
                             <Route exact path="/hrana/add" component={AddHrana} />
                             <Route exact path="/prilozi" component={Prilozi} />
                             <Route exact path="/prilozi/edit/:id" component={EditPrilog} />
                             <Route exact path="/prilozi/add" component={AddPrilog} />
                             <Route exact path="/pica" component={Pica} />
                             <Route exact path="/pica/edit/:id" component={EditPica} />
                             <Route exact path="/pica/add" component={AddPice} />
                             <Route exact path="/porudzbine" component={Porudzbine} />
                             <Route exact path="/porudzbine/add" component={AddPorudzbina} />
                             <Route exact path="/porudzbine/stavke/:id" component={Stavke} />
                             <Route exact path="/porudzbina/addstavke/:id" component={AddStavke} />
                             <Route exact path="/porudzbine/naplataporudzbine/:id" component={NaplataPorudzbine} />
                             <Route component={NotFound} />
                        </Switch>
                    </Container>

                </Router>
            </div>
        )
    }

}

ReactDOM.render(
    <App/>,
    document.querySelector('#root')
);