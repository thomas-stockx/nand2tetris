// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

// Implementation by Thomas Stockx

// Pseudo code:
// R2 = 0;
// n = R1;
// while (n > 0) {
//  R2 = R2 + R0;
//  n = n - 1;
// }

// Initialisation
    // R2 = 0;
    @R2
    M=0 
    // n = R1;
    @R1
    D=M
    @n
    M=D
    
// While loop
(LOOP)
    // Check while loop condition
    // while (n > 0)
    @n
    D=M
    // if n == 0 go to END
    @END
    D;JEQ
    
    // Do while loop internals
    // R2 = R2 + R0;
    @R0
    D=M
    @R2
    M=D+M
    // n = n - 1;
    @n
    M=M-1
    
    // jump to condition check of while loop
    @LOOP
    0;JMP

    
// Infinite loop to end
(END)
    @END
    0;JMP
    