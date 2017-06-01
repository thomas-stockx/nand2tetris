// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Implementation by Thomas Stockx

// pseudo code:

// while(true) {
//   if (@KBD > 0) {
//      color = -1;
//   } else {
//      color = 0;
//   }
//   FillScreen(color);
// }

// Infinite loop
(INFINITELOOP)
    // get keyboard value
    @KBD
    D=M
    
    // Jump to Black method if keyboard value > 0
    @BLACK
    D;JGT
    
    // set color to white
    @color
    M=0
    
    // jump to draw method
    @DRAW
    0;JMP
    
(BLACK)
    @color
    M=-1
    
(DRAW)
    // Initialise the drawing variables
    // We'll need to do 8192 words to do the full screen
    @8192
    D=A
    @n
    M=D
    // save the address of the screen
    @SCREEN
    D=A
    @address
    M=D
    
// Draw the color on every word of the screen memory
(DRAWLOOP)
    @n
    D=M
    // if n == 0 we've finished so back to the start of the program (infinite loop)
    @INFINITELOOP
    D;JEQ
    
    // draw color to address
    @color
    D=M
    @address
    A=M
    M=D
    
    // increase address
    @address
    M=M+1
    
    // decrease n
    @n
    M=M-1
    
    @DRAWLOOP
    0;JMP
    
    
    
    
    
    
    
    
    
    
    