

const menuItems = 
  { BreakFast :
    [ { itemName: 'pancakes',  price: 8.95, label: 'Blueberry Pancakes' }
    , { itemName: 'omlette',   price: 8.95, label: 'Vegetable Omelette' }
    , { itemName: 'croissant', price: 5.95, label: 'Croissant'          }
    , { itemName: 'muffin',    price: 8.95, label: 'Blueberry Muffin'   }
    ]
  , Lunch :
    [ { itemName: 'cheeseburger', price: 10.95, label: 'Cheeseburger'  }
    , { itemName: 'teriyaki',     price: 12.95, label: 'Teriyaki Wrap' }
    , { itemName: 'salad',        price: 13.95, label: 'Ceasar Salad'  }
    , { itemName: 'soup',         price: 11.95, label: 'Tomato Soup'   }
    ]
  , Beverages :
    [ { itemName: 'coffee', price:  1.95, label: 'Black Coffee'      }
    , { itemName: 'tea',    price: 11.95, label: 'Green Tea'         }
    , { itemName: 'beer',   price:  5.95, label: 'Corona Beer 12 oz' }
    , { itemName: 'milk',   price:  3.95, label: 'Chocolate Milk'    }
    ]
  }

const
  myForm = document.querySelector('#my-form-id')
, total  = document.querySelector('#total > em')

for (let menu in menuItems) // build the menu
  {
  let menuPart = document.createElement('fieldset') 
  menuPart.innerHTML = `<legend>${menu}</legend>`
  menuItems[menu].forEach(item=>
    {
    menuPart.innerHTML += `
        <label>
          <b>${item.label}</b>
          <input type="checkbox" name="${item.itemName}" value="${item.price}">
          <em>$ ${item.price}</em>
        </label>`
    })
  myForm.querySelector('.cols-3-parts').appendChild(menuPart)
  }
myForm.onsubmit = e =>
  {
  e.preventDefault() // disable submit while testing

  let inputJSON = Array.from(new FormData(myForm))
    .reduce((r,[name,value])=>{ r[name]= isNaN(value) ? value : Number(value); return r} ,{}) 
  console.log( JSON.stringify( inputJSON ))
  setTimeout(console.clear, 2000);
  }
myForm.onreset = e =>
  {
  total.textContent = '0.00'
  }
myForm.oninput = e =>
  {
  let  totalVal = 0;
  Array.from(new FormData(myForm))
    .forEach(([name,value])=> totalVal += isNaN(value) ? 0 : Number(value) ) 
    
  total.textContent = totalVal.toFixed(2)
  }

