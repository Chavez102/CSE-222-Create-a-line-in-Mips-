.data

	Xarray: .space 100		#array for 25 integers
	Yarray: .space 100		#array for 25 integers
	
	AskX1: .asciiz "What is x position of Point1 \n"
	AskY1: .asciiz "What is y position of Point1 \n"
	AskX2: .asciiz "What is x position of Point2 \n"
	AskY2: .asciiz "What is y position of Point2 \n"
	newline: .asciiz "\n"
	
	
	
	
.text
	main:
		#jal AskforPoint1  #x1=$t0  y1=$t1
		#jal AskforPoint2  #x2=$t2  y2=$t3
		
		
		
	addi $s0,$zero,100
	addi $t0,$zero,0		# t=index=$t4


	
	SetArraysValueto100:
	
		bgt $t4,100,continue
		
		sw $s0,Xarray($t4)			#Xarray[i]=100
		sw $s0,Yarray($t4)			#Yarray[i]=100
		
	
		addi $t4,$t4,4
		j SetArraysValueto100
		
		
	continue:
	
	
	
		jal printArray
	
	
	

	#end of main
	li $v0,10
	syscall
	
	
	
	
	printArray:
		addi $t4,$zero,0
		ArrayPrinting:
			bgt $t4,100,backfromPrinting
			
			lw $t5,Xarray($t4)
			lw $t6,Yarray($t4)
			
			addi $t4,$t4,4
		
			#printx
			li $v0,1
			addi $a0,$t5,0
			syscall
		
			jal printnewline
		
			j ArrayPrinting
		
	BackfromPrinting:
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	printnewline:
		li $v0,4
		la $a0,newline
		syscall
	   	
	   	#end of method
		jr $ra
	
	
	
	AskforPoint1:
		#display ask for x1 Point1
		li $v0,4
		la $a0,AskX1
		syscall
		
		#get input 	
		li $v0,5
		syscall
		
		move $t0,$v0					 #x1 = $t0
		
		#display ask for Y1 Point1
		li $v0,4
		la $a0,AskY1
		syscall
		
		#get input for Y1	
		li $v0,5
		syscall
		move $t1,$v0					#Y1=$t1								
		
		#end of method
		jr $ra
		
		
		
	AskforPoint2:
		#display ask for x2 Point2
		li $v0,4
		la $a0,AskX2
		syscall
		
		#get input x2	
		li $v0,5
		syscall
		move $t2,$v0					#X2 = $t2
		
		
		
		
		#display ask for x Point2
		li $v0,4
		la $a0,AskY2
		syscall
		
		#get input Y2
		li $v0,5
		syscall
		move $t3,$v0				   #Y2 = $t3
		
		
		#end of method
		jr $ra
