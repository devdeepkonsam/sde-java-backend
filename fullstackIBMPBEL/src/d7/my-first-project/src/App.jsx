
import Employee from "./Employee"
import "./employee.css"
import "./App.css"
import React, { useState } from 'react';

//   return (
//     <>
//     <h1> Hello everyone from Assam</h1>

//     <p>lsdflajdslkfjlkdsajflkadsjlfksajlkfjalkfjsaflkajlfkjssalkfjsaf</p>
//     <a href="www.google.com">Google</a>
//     </>
//   )
// }

// export default App

//what is props 
//lets understand it with an example


// function App() {
//   return(
//     <>
//     <Restaurant
//     name = "Chicken Tikka Masala"
//     type = "Non-Veg"
//     rating = {4.5}
//     price = {299}
//     quantity = "500gm"
//     />
//     <Restaurant
//     name = "Panner Tikka Masala"
//     type = "Veg"
//     rating = {3.5}
//     price = {199}
//     quantity = "200gm"
//     />
//     <Restaurant
//     name = "Dal makhani"
//     type = "Veg"
//     rating = {4.6}
//     price = {149}
//     quantity = "150gm"
//     />
//     <Restaurant
//     name = "Pork Curry"
//     type = "Non-veg"
//     rating = {5}
//     price = {299}
//     quantity = "500gm"
//     />

//     </>
//   )
// }

// export default App


function App() {
	return (
		<main className="app-main">
			<div className="employee-grid">
				<Employee
					name="Dev"
					department="Engineering"
					salary="₹85,000"
					age={28}
					experience="5 years"
				/>
				<Employee
					name="Pritam"
					department="Sales"
					salary="₹55,000"
					age={26}
					experience="3 years"
				/>
				<Employee
					name="Shreya"
					department="Marketing"
					salary="₹75,000"
					age={30}
					experience="6 years"
				/>
				<Employee
					name="Vikram"
					department="DevOps"
					salary="₹1,20,000"
					age={34}
					experience="10 years"
				/>
				<Employee
					name="Anand"
					department="Product"
					salary="₹95,000"
					age={29}
					experience="6 years"
				/>
			</div>
		</main>
	)
}
export default App


//counter
// function App() {

//   const [incre, setIncre] = useState(0)//initial value  ----->;
//   return (
//     <>
//     <h1>Counter Application</h1>
//     <h3>{incre}</h3>
//     <button onClick={() => setIncre(incre+1)}>increment</button>
//     <button onClick={() => setIncre(incre-1)}>decrement</button>
//     <button onClick={() => setIncre(incre*incre)}>square</button>
//     <button onClick={() => setIncre(incre*2)}>multiply by 2</button>
//     <button onClick={() => setIncre(incre/2)}>divide by 2</button>
//     <button onClick={() => setIncre(Math.sqrt(incre))}>sqrt</button>
//     <button onClick={() => setIncre(incre % 10)}>modulo by 10</button>
//     <button onClick={() => setIncre(0)}>reset</button>
//     </>
//   )
// }

// export default App