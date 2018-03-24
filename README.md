# nand2tetris
Projects implemented for the course "The Elements of Computing Systems: Building a Modern Computer from First Principles", also known as Nand2Tetris.

## TL;DR Current State
Implemented up to Project 7:

Given a Virtual Machine language program containing Arithemtic commands and Memory Access commands:
* Translate to Hack Assembly by using the VM Translator written in Project 7.
* Translate Hack Assembly to binary by using the Assembler written in Project 6.
* Load the binary code as ROM in the Computer chip built in Project 5 and execute it.
* The Computer chip is built out of other chips during Project 1-4, and only have a basic NAND gate and Data Flip Flop gate as primitives.

## Long version

### Project 1 (Logic Gates)
Built logic gates with NAND gates as the only building block, which run in a Hardware Simulator:
* Not
* And
* Or, Xor
* Multiplexor, Demultiplexor
* Multi-Bit Not, And, Or
* Multi-Bit Multiplexor
* Multi-Bit, Multi-Way Multiplexor, Demultiplexor

### Project 2 (ALU)
Implemented chips based on the logic gates built in Project 1:
* Half-Adder
* Full-Adder
* Adder
* Incrementer

Using all of the previously built chips and gates, built an Arithmetic Logic Unit (ALU).

### Project 3 (RAM Storage and Program Counter)
Given a Data Flip Flop gate as a building block, built the following chips:
* 1-Bit Register
* Register
* 8-Register Memory (RAM8)
* n-Register Memory (up to RAM16K)
* Program Counter (PC)

### Project 4 (Trying out Hack Assembly)
Wrote two simple programs in the Hack Assembly language to get a feel for how the assembly language works and feels.

### Project 5 (Computer)
Using all of the chips built in the previous projects, built a Computer chip, containing:
* Data Memory (RAM)
* Instruction Memory (ROM)
* CPU chip

### Project 6 (Assembler)
Built a HackAssembler in Kotlin which translates a program written in the Hack Assembly language to binary that can be executed on the Computer chip built in Project 5.

### Project 7 (Virtual Machine Translator)
First iteration of a VM Translator in written in Java that can translate a program from a Stack-based VM Language to Hack Assembly, so it can be translated into binary by the Assembler written in Project 7. Supported VM Language features:
* Arithemtic commands
* Memory access commands

### TODO Project 8 and up.
