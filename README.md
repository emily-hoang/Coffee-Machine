# JAVA COFFEE MACHINE PROJECT
## Phase 1

### Description:
A real coffee machine never has an infinite supply of water, milk, or coffee beans. And if you input a really
big number, it’s almost certain that a real coffee machine wouldn't have the supplies needed to make all that
coffee.<br>
In this stage, you need to improve the previous program. Now you need to input amounts of water, milk, and
coffee beans that your coffee machine has at the moment.
If the coffee machine has enough supplies to make the specified amount of coffee, the program should print
"Yes, I can make that amount of coffee".<br>
If the coffee machine can make more than that, the program should output "Yes, I can make that amount of
coffee (and even N more than that)", where N is the number of additional cups of coffee that the coffee
machine can make.<br>
If the amount of resources is not enough to make the specified amount of coffee, the program should output
"No, I can make only N cup(s) of coffee".<br>
The coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans
to make one cup of coffee.<br>

### Instruction
Write a program that calculates whether it will be able to make the required amount of coffee from the
specified amount of ingredients.

The program should firstly request for water, then milk, then beans, then amount of cups.
The symbol > represents the user input. Notice that it's not the part of the input.

#### Example 1
Write how many ml of water the coffee machine has:<br>
`> 300`<br>
Write how many ml of milk the coffee machine has:<br>
`> 65`<br>
Write how many grams of coffee beans the coffee machine has:<br>
`> 100`<br>
Write how many cups of coffee you will need:<br>
`> 1`<br>
Yes, I can make that amount of coffee
#### Example 2

Write how many ml of water the coffee machine has:<br>
`> 500`<br>
Write how many ml of milk the coffee machine has:<br>
`> 250`<br>
Write how many grams of coffee beans the coffee machine has:<br>
`> 200`<br>
Write how many cups of coffee you will need:<br>
`> 10`<br>
No, I can make only 2 cup(s) of coffee
#### Example 3

Write how many ml of water the coffee machine has:<br>
`> 1550`<br>
Write how many ml of milk the coffee machine has:<br>
`> 299`<br>
Write how many grams of coffee beans the coffee machine has:<br>
`> 300`<br>
Write how many cups of coffee you will need:<br>
`> 3`<br>
Yes, I can make that amount of coffee (and even 2 more than that)
#### Example 4
Write how many ml of water the coffee machine has:<br>
`> 0`<br>
Write how many ml of milk the coffee machine has:<br>
`> 0`<br>
Write how many grams of coffee beans the coffee machine has:<br>
`> 0`<br>
Write how many cups of coffee you will need:<br>
`> 1`<br>
No, I can make only 0 cup(s) of coffee

#### Example 5
Write how many ml of water the coffee machine has:<br>
`> 0`<br>
Write how many ml of milk the coffee machine has:<br>
`> 0`<br>
Write how many grams of coffee beans the coffee machine has:<br>
`> 0`<br>
Write how many cups of coffee you will need:<br>
`> 0`<br>
Yes, I can make that amount of coffee

#### Example 6

Write how many ml of water the coffee machine has:<br>
`> 200`<br>
Write how many ml of milk the coffee machine has:<br>
`> 50`<br>
Write how many grams of coffee beans the coffee machine has:<br>
`> 15`<br>
Write how many cups of coffee you will need:<br>
`> 0`<br>
Yes, I can make that amount of coffee (and even 1 more than that)

## Phase 2
### Description
Let's simulate an actual coffee machine. It has a limited supply of water, milk, coffee beans, and disposable cups.
Also, it counts how much money it gets for selling coffee. The coffee machine has several options: first, it needs to be able to sell coffee.
It can make different varieties of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies,
except that all of them requires only one disposable cup. Second, the coffee machine should be able to get replenished by a special worker.
Third, another special worker should be able to take money from the coffee machine.<br>

Write the program that can do one of these actions at a time. It reads one line from standard input, which can be "buy", "fill", "take".
If you want to buy some coffee, input "buy". If you are a special worker and you think that it is time to fill out all the supplies for the
coffee machine, input "fill". If you are another special worker and it is time to take the money from the coffee machine, input "take".<br>

If the user writes "buy" then he must choose one of three varieties of coffee that the coffee machine can make: espresso, latte, or cappuccino.<br>

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.<br>
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.<br>
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.<br>
If the user writes "fill", the program should ask him how much water, milk, coffee, and how many disposable cups he wants to add to the coffee machine.<br>

If the user writes "take" the program should give him all the money that it earned from selling coffee.<br>

At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.<br>

Write the program that prints the coffee machine’s state, processes one query from the user, and also prints the coffee machine’s state after that. Try to use methods to implement every action that the coffee machine can do.<br>

### Instruction
Write a program that offers to buy one cup of coffee or to fill the ingredients or to take its money. At the same time, the program should calculate how many ingredients it has left. And also display the number of ingredients before and after purchase.<br>

### Examples
An espresso should be as number 1 in the list, a latte as number 2 and a cappuccino as number 3.
Options also should be named as "buy", "fill", "take".<br>
The symbol > represents the user input. Notice that it's not the part of the input.

#### Example 1
The coffee machine has:<br>
400 of water<br>
540 of milk<br>
120 of coffee beans<br>
9 of disposable cups<br>
550 of money<br>

Write action (buy, fill, take):<br>
`> buy`<br>
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:<br>
`> 3`<br>

The coffee machine has:<br>
200 of water<br>
440 of milk<br>
108 of coffee beans<br>
8 of disposable cups<br>
556 of money<br>

#### Example 2
The coffee machine has:<br>
400 of water<br>
540 of milk<br>
120 of coffee beans<br>
9 of disposable cups<br>
550 of money<br>

Write action (buy, fill, take):<br>
`> fill`<br>
Write how many ml of water do you want to add:<br>
`> 2000`<br>
Write how many ml of milk do you want to add:<br>
`> 500`<br>
Write how many grams of coffee beans do you want to add:<br>
`> 100`<br>
Write how many disposable cups of coffee do you want to add:<br>
`> 10`<br>

The coffee machine has:<br>
2400 of water<br>
1040 of milk<br>
220 of coffee beans<br>
19 of disposable cups<br>
550 of money<br>

#### Example 3
The coffee machine has:<br>
400 of water<br>
540 of milk<br>
120 of coffee beans<br>
9 of disposable cups<br>
550 of money<br>

Write action (buy, fill, take):<br>
`> take`<br>

I gave you $550

The coffee machine has:<br>
400 of water<br>
540 of milk<br>
120 of coffee beans<br>
9 of disposable cups<br>
0 of money<br>