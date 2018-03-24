# nand2tetris
Projects implemented for the course "The Elements of Computing Systems: Building a Modern Computer from First Principles", also known as Nand2Tetris.

## Project 1 (Logic Gates)
Built logic gates with NAND gates as the only building block, which run in a Hardware Simulator:
* Not
* And
* Or, Xor
* Multiplexor, Demultiplexor
* Multi-Bit Not, And, Or
* Multi-Bit Multiplexor
* Multi-Bit, Multi-Way Multiplexor, Demultiplexor

## Project 2 (ALU)
Implemented chips based on the logic gates built in Project 1:
* Half-Adder
* Full-Adder
* Adder
* Incrementer

Using all of the previously built chips and gates, built an Arithmetic Logic Unit (ALU).

## Project 3 (RAM Storage and Program Counter)
Given a Data Flip Flop gate as a building block, built the following chips:
* 1-Bit Register
* Register
* 8-Register Memory (RAM8)
* n-Register Memory (up to RAM16K)
* Program Counter (PC)

## Project 4 (Trying out Hack Assembly)
Wrote two simple programs in the Hack Assembly language to get a feel for how the assembly language works and feels.

## Project 5 (Computer)
Using all of the chips built in the previous projects, built a Computer chip, containing:
* Data Memory (RAM)
* Instruction Memory (ROM)
* CPU chip

## Project 6 (Assembler)
Built a HackAssembler in Kotlin which translates a program written in the Hack Assembly language to binary that can be executed on the Computer chip built in Project 5.

## Project 7 (Virtual Machine Translator)
First iteration of a VM Translator in written in Java that can translate a program from a Stack-based VM Language to Hack Assembly, so it can be translated into binary by the Assembler written in Project 7. Supported VM Language features:
* Arithemtic commands
* Memory access commands

## TODO Project 8 and up.
