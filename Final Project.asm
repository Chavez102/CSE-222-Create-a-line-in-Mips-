.data
	AskX1: .asciiz "What is x position of Point1"
	AskY1: .asciiz "What is y position of Point1"
	AskX2: .asciiz "What is x position of Point2"
	AskY2: .asciiz "What is y position of Point2"
	
.text
	main:
		jal AskforPoint1  #x1=$t0  y1=$t1
		jal AskforPoint2  #x2=$t2  y2=$t3
		
		

		







	#end of main
	li $v0,10
	syscall
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		la $a0,AskX1
		syscall
		
		#get input x2	
		li $v0,5
		syscall
		move $t2,$v0					#X2 = $t2
		
		
		
		
		#display ask for x Point2
		li $v0,4
		la $a0,AskY1
		syscall
		
		#get input Y2
		li $v0,5
		syscall
		move $t3,$v0				   #Y2 = $t3
		
		
		#end of method
		jr $ra
