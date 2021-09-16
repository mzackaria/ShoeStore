# ShoeStore

This project is a pet project to show case the use of the navigation component of the Android Framework.

This project is written in Kotlin.

## The app

To show case this project, we used a simple shoe store app with 5 screens: 

- Login screen
- Welcome Screen
- Instruction Screen
- List Of Shoes Screen
- Add New Shoe Screen

Once the user is logged in (mocked functionality) we simply display the list of shoes. If the user want to add a new shoe, he/she must click on the bottom-right button and go on the Add New Show Screen to add a new shoe.

## The code

You can find a simple show case of the navigation component with 2 main components: 

- The login navigation graph: integrate the login screen, the welcome screen, the instruction screen
- The main navigation graph: integrate the login nav graph, the "list of shoe"  screen, the "new shoe" screen

Once you're logged in, you shouldn't be able to go back to the login screen (except by login out) as the 2 graphs are independent.

