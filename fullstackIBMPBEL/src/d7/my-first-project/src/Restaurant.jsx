// function Restaurant(dishes) {
//     return (
//         <>
//         <h3>{dishes.name}</h3>
//         <h3>{dishes.type}</h3>
//         <h3>{dishes.rating}</h3>
//         <h3>{dishes.price}</h3>
//         <h3>{dishes.quantity}</h3>
//         </>
//     )
// }
// export default Restaurant
function Restaurant({name,type,rating,price,quantity}) {
    return (
        <>
        <h3>{name}</h3>
        <h3>{type}</h3>
        <h3>{rating}</h3>
        <h3>{price}</h3>
        <h3>{quantity}</h3>
        </>
    )
}
export default Restaurant