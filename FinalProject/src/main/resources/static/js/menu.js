

var menuItems = [
	{
	itemName : "salad",
	price : 13.95 
},
{
	itemName : "pancakes",
	price : 8.95 
},
{
	itemName : "omlette",
	price : 8.95 
},
{
	itemName : "croissant",
	price : 5.95 
},
{
	itemName : "muffin",
	price : 8.95 
},
{
	itemName : "cheeseburger",
	price : 10.95 
},
{
	itemName : "teriyaki",
	price : 12.95 
},{
	itemName : "soup",
	price : 11.95 
},
{
	itemName : "coffee",
	price : 1.95 
},
{
	itemName : "tea",
	price : 11.95 
},
{
	itemName : "beer",
	price : 5.95 
},
{
	itemName : "milk",
	price : 3.95 
},
]

var total = 0;
var selected = document.querySelectorAll("input[type='checkbox']")
        .forEach(checkbox => {
          checkbox.addEventListener('click', function () {
            if(selected.checked) 
			total+=menuItems.price;
        });
});

console.log(total);



