import React from 'react'

class Home extends React.Component {
  render() {
    return (
       <div>
         {/* <div class="p-3 mb-2 bg-primary text-white">.bg-primary</div> */}
         <div class="has-bg-img">
           <h2>Italijanski restoran</h2>
           <h4>Dobro dosli! Wellcome!</h4>
           <img class="bg-img" src="hrana.jpg" alt="hrana" style={{
                position: 'absolute',
                top: 50,
                left: 0,
                right: 0,
                bottom: 0,
                height: '100%',
                width: '100%',
                objectFit: 'cover',
              }} ></img>
         </div> 
        
        {/* <div id="carouselExampleIndicators" class="courusel slide" data-bs-ride="carousel">
          <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="pizza.jpg" class="d-block w-100" alt="pizza"></img>
            </div>
            <div class="carousel-item">
              <img src="pasta.jpg" class="d-block w-100" alt="pasta"></img>
            </div>
            <div class="carousel-item">
              <img src="hrana.jpg" class="d-block w-100" alt="hrana"></img>
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>  */}
        
        </div>

)
    
    }
  }
export default Home;