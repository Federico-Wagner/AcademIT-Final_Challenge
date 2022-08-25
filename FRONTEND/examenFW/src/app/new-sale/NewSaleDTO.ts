export class NewProductDTO{
  vendor_id: number = 0
  cart : Array<DTOHelper>
}

class DTOHelper{
  product_id : number =  0
  amount : number = 0
}



// {
//   "vendor_id": 1,
//   "cart":[
//   {
//     "product_id" : 3,
//     "amount" :  23
//   },
//   {
//     "product_id" : 1,
//     "amount" :  122
//   },
//   {
//     "product_id" : 2,
//     "amount" :  90
//   }
// ]
// }
