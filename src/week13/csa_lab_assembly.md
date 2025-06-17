Question 1
```text
; Author: Kearney Leith
; Program Name: Sum of Differences
; Program Description:  Write a program with indexed addressing that calculates the sum of all the gaps between array
;                       elements. The array elements are word type, sequenced in non-decreasing order. Use the
;                       value array {0,2,5,9,10}. These values has a gaps of 2,3,4, and 1 which the total of 10. 
; Date: 15 June 2025

INCLUDE Irvine32.inc

.data
    array WORD 0, 2, 5, 9, 10       ; Define the array

.code
    main PROC
    mov edx, 0  	                ; Initialize results to 0
    mov esi, OFFSET array           ; Load the address of the array into esi
    mov ecx, LENGTHOF array - 1     ; the number of elements in the array minus 1

Loop1:
    mov ax, [esi]                   ; Load the current element into eax
    mov bx, [esi + 2]               ; Load the next element into ebx (2 bytes ahead for WORD))
    sub bx, ax                      ; Subtract the current element from the next element
    add dx, bx                      ; Add the result to edx
    add esi, 2                      ; Move to the next element (2 bytes for WORD)
loop Loop1                          ; Decrement ecx and repeat if not zero

call DumpRegs                       ; Display outputs

; Exit
exit                
main ENDP
END main

; Answer: The program calculates the sum of the gaps between the elements of the array, which is 10 (saved in EDX).
```

Question 2
```text
; Author: Kearney Leith 
; Program Name: Print triangle of numbers
; Program Description: 
; Write an assembly code to generate a sequence of number when a number is initialized.
; Follow the below instruction:
; a. Initialize a number which is 8.
; b. Use all available register to perform an instruction that can generate a sequence of
; number 1,2,3,4,5,6,7,8,. The output should be like this:
; 1 2 3 4 5 6 7 8
; 2 3 4 5 6 7 8
; 3 4 5 6 7 8
; 4 5 6 7 8
; 5 6 7 8
; 6 7 8
; 7 8
; 8
; Date: 15 June 2025

INCLUDE Irvine32.inc

.data
number DWORD 8				; Initialize 8

.code
main PROC					; Main procdure
mov ebx,1					; initialise ebx as one bc the series of number starts with 1
mov ecx,ebx					; move ebx into ecx for Func1 because ecx is going to increase from original value to 8, ebx increment every cycle

Func1:	
	cmp ebx, number			; compare ebx with number(8)
	jg Func3				; jump if ebx greater than 8
	mov eax, ecx			; move current value of number which needs to be print to eax
	call WriteDec			; print number
	inc ecx					; increment ecx by 1
	cmp eax, number			; compare eax with number(8)
	jl Func1				; jump to Func1 if eax less then number(8), which is similar to looping it
	je Func2				; jump to Func2 if eax equal to number(8)

Func2:
	call Crlf				; skip a line
	inc ebx					; increment ebx by one since the next line will start from one number behind
	mov ecx,ebx			    
	jmp Func1

Func3:						; exit the loop

exit
main ENDP
END main

```

Question 3
```text
; Author: Kearney Leith 
; Program Name: Calculator 
; Program Description: Write a program that prompts the user for three 32-bit integers stores them in an array,
;					   calculates the sum of the array, and displays the sum on the screen. 
; Date: 15 June 2025

INCLUDE Irvine32.inc

.data
input SDWORD ?, ? , ?									; Array to store three integers
question BYTE "Enter 32-bit integers: ", 0				; Prompt for input
answer BYTE "The sum of the 32-bit integers is: ", 0	; Message to display the sum

.code
main PROC

	; 
	mov ecx, LENGTHOF input ; Set loop counter for 3 integers
	mov edi, OFFSET input   ; Point EDI to the start of the input array

Loop1:
	mov edx, OFFSET question ; Load the address of the question
	call WriteString         ; Display the question
	call ReadInt           ; Read an integer from the user

	mov [edi], eax          ; Store the integer in the array
	add edi, TYPE input ; Move to the next element in the array
	loop Loop1              ; Repeat for 3 integers ; ECX--, jump if ECX != 0

	mov eax, 0					;initialize eax	to 0 for sum
	mov ecx, LENGTHOF input ; Reset loop counter for summation
	mov edi, OFFSET input   ; Reset EDI to the start of the input array

Loop2:
	add eax, [edi]          ; Add the current integer to the sum
	add edi, TYPE input     ; Move to the next element in the array
	loop Loop2				; Repeat for all integers; ECX--, jump if ECX != 0
	mov edx, OFFSET answer  ; Load the address of the answer message
	call WriteString         ; Display the answer message
	call WriteInt            ; Display the sum in EAX
	call Crlf               ; Print a new line

exit
main ENDP
END main
```

Question 4
```text
; Author: Kearney Leith
; Program Name: Q4 - Grade Calculator
; Program Description: Create a procedure that receives an integer value between 0 and 100. Then, display a single
;					   capital letter on the screen. The letter returned by the procedure should be according to the
;					   following ranges.
;					   90 to 100 ---- A
;					   80 to 89 ------ B
;					   70 to 79 ------ C
;					   60 to 69 ------ D
;					   0 to 59 -------- F
; Date : 15 June 2025

INCLUDE Irvine32.inc

.data
    promptMsg   BYTE "Enter mark (0-100): ",0 ; Prompt message for user input
    gradeLetter BYTE ? ; To store the grade letter
    newline     BYTE 13,10,0 ; Carriage return and line feed for new line

.code

DisplayGradeLetter PROC ; Receives an integer in EAX and returns a grade letter in AL
    cmp eax, 90     ; Check if grade is 90 or above
    jge gradeA      ; If so, jump to gradeA
    cmp eax, 80    ; Check if grade is 80 or above  
    jge gradeB      ;; If so, jump to gradeB
    cmp eax, 70     ; Check if grade is 70 or above
    jge gradeC      ;; If so, jump to gradeC
    cmp eax, 60     ; Check if grade is 60 or above
    jge gradeD
    mov al, 'F'
    ret
gradeA:
    mov al, 'A'
    ret
gradeB:
    mov al, 'B'
    ret
gradeC:
    mov al, 'C'
    ret
gradeD:
    mov al, 'D'
    ret
DisplayGradeLetter ENDP

main PROC
    ; Prompt user for grade
	mov edx, OFFSET promptMsg       ; Prepare prompt message
    call WriteString        ; Display prompt message
    call ReadInt         ; EAX = user input

    ; Call procedure to get grade letter
    push eax            ; Save input
    call DisplayGradeLetter ; Call procedure to get grade letter
    mov gradeLetter, al ; Store result
    pop eax             ; Restore input (not strictly needed here)

    ; Display result
    mov al, gradeLetter ; Load grade letter into AL
    call WriteChar ; Display the grade letter
    mov edx, OFFSET newline     ;; Prepare newline
    call WriteString    ; Display newline

    call WaitMsg ; Wait for user to press a key before exiting
    exit
main ENDP
END main
```
