.data

	Xarray: .space 100		#array for 25 integers
	Yarray: .space 100		#array for 25 integers
	
	AskX1: .asciiz "What is x position of Point1 \n"
	AskY1: .asciiz "What is y position of Point1 \n"
	AskX2: .asciiz "What is x position of Point2 \n"
	AskY2: .asciiz "What is y position of Point2 \n"
	newline: .asciiz "\n"
	
	
	star: .asciiz "x "
	dash: .asciiz "_ "
	
	
	false: .asciiz "false \n"
	true: .ascii  "true \n"
	
	coma: .asciiz ","
	zeroDouble: .double 0.0
	twoDouble: .double 2.0

#git working fine
	
.text
	main:
		jal AskforPoint1  #x1=$t0  y1=$t1
		jal AskforPoint2  #x2=$t2  y2=$t3
		
		addi $s0,$zero,100
		addi $t4,$zero,0		# t=index=$t4


	
		#dx=x2-realx  $t5=$t2-$t0
		add $t5,$zero,$t2	#dx=x2
		sub $t5,$t5,$t0	#dx=x2-realx
		
		
	#dy=y2-realy  $t6=$t3-$t1
		add $t6,$zero,$t3	
		sub $t6,$t6,$t1
		
	# double P=(2*dy)-dx
		ldc1 $f0,zeroDouble
		ldc1 $f2,twoDouble
		
		
		mtc1.d $t6,$f6
		cvt.d.w $f6,$f6
		add.d $f4,$f6,$f0   #P=dy
		
		
		mul.d $f4,$f4,$f2   #P=2dy
		
		mtc1.d $t5, $f8
  		cvt.d.w $f8, $f8
		sub.d $f4,$f4,$f8   #P=2dy-dx
		
	#index= 0; #t4=0
		add  $t4,$zero,$t4


	


	
	
	
	
	
	SetArraysValueto100:
	
		bgt $t4,100,continue1
		
		sw $s0,Xarray($t4)			#Xarray[i]=100
		sw $s0,Yarray($t4)			#Yarray[i]=100
		
	
		addi $t4,$t4,4
		j SetArraysValueto100
		
		
	continue1:




		addi $t2,$t2,1			#$t0=x2 =>$t2=$t2+a1  $t2=x2+1
		add $t4,$zero,$zero
	LineScanConversionFunc:
			bgt $t0,$t2,comebackfromAlgorithm
				sw $t0,Xarray($t4)			#Xarray[index]=realx;
				sw $t1,Yarray($t4)			#Yarray[index]=realy;
				addi $t4,$t4,4				#index++
				
				addi $t0,$t0,1					#realx++
				
				c.lt.d $f4,$f0
				bc1t IfPlessThanZero
				bc1f IfPisEqualorGreaterthanZero
				comeback:
				
				j LineScanConversionFunc
	
	IfPlessThanZero:
		#jal printtrue
		mul.d $f10,$f6,$f2		#2*dy
		add.d $f4,$f4,$f10		#P=P+(2*dy)
		
		div.d $f10,$f10,$f2			#f10/f2=> Original
		
		
	   	#end of method
		j comeback
	
	
	IfPisEqualorGreaterthanZero:
		#jal printfalse
	
	
		#p=p+(2*dy)-(2*dx)
		mul.d $f10,$f6,$f2   #$f10=dy*2
		mul.d $f8,$f8,$f2	 #f8=dx*2
		sub.d $f2,$f10,$f8	 #$f2=$f10-$f8
		add.d $f4,$f4,$f2      #p=p+(2*dy)-(2*dx)
		
		ldc1 $f2,twoDouble		#f2=2.0=>original
		div.d $f10,$f10,$f2			#f10/f2=> Original
		div.d $f8,$f8,$f2
		
	
		#realy++;
		addi $t1,$t1,1
	
		#end of method
		j comeback
	
	
	
	comebackfromAlgorithm:
	
	
	
	
	printArray:
	
		addi $t4,$zero,0
	
			
		
	BackfromPrinting:
#######################################################
		addi $s1,$zero,1		#use for true=1
		addi $t3,$zero,0		#$PrintIt=false; 
		addi $t4,$zero,24		#$t4= columns=24
		addi $t2,$zero,0		#$t2= rows=0
		addi $t7,$zero,0         #$t7=insiderow=0
		addi $t1,$zero,0		#$t1=index=0
		
		
	GraphPrinting:
			blt $t4,$zero,EndOfGraphPrinting
			firstinsideloop:
				bgt $t2,25,continuelooop
			#	jal printstar
# for( insiderow=0;insiderow<height;insiderow++)
						insideloop:
							bgt $t7,25,endinsideloop

								lw $t5,Xarray($t1)
								lw $t6,Yarray($t1)
								
							#if STATEMENT
								beq $t2,$t5,RowsEqualXarray			#rows==Xarray[index]
								bne $t2,$t5,NotEqual
								
								RowsEqualXarray:
								beq $t4,$t6,RowsandColumnsEqual		#colums==Yarra
								bne $t4,$t6,NotEqual
								
	
								RowsandColumnsEqual:
								addi $t3,$zero,1		#s PrintIt=tru
							
								NotEqual:
								
							addi $t7,$t7,1
							addi $t1,$t1,4			#index=index+4
							
							j insideloop
						endinsideloop:
		#end of insideloop
		
				beq $t3,$s1,PrintItisTrue
				bne $t3,$s1,else
				PrintItisTrue:
					jal printstar
					beq $t3,$s1,keepgoing
					
				else:
					jal printdash
				keepgoing:
						addi $t3,$zero,0         #reset PrintIT to false
						addi $t7,$zero,0		#reset insiderow
						addi $t1,$zero,0		#reset index
				addi $t2,$t2,1
						
				j firstinsideloop
			
			continuelooop:
		
			
			
			
			
			
			
			addi $t2,$zero,0		#$t2= rows=0   RESET
			jal printnewline
			subi $t4,$t4,1
			
			j GraphPrinting
#############################################			
		EndOfGraphPrinting:
		
		
				
	
	

	#end of main
	li $v0,10
	syscall

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	printtrue:
		li $v0,4
		la $a0,true
		syscall
	   	
	   	#end of method
		jr $ra
		
	printfalse:
		li $v0,4
		la $a0,false
		syscall
	   	
	   	#end of method
		jr $ra
		
		
		
	printdash:
		li $v0,4
		la $a0,dash
		syscall
	   	
	   	#end of method
		jr $ra
	
		
		
		
		
	printstar:
		li $v0,4
		la $a0,star
		syscall
	   	
	   	#end of method
		jr $ra
	
	
	
	
	
	
	
	printcoma:
		li $v0,4
		la $a0,coma
		syscall
	   	
	   	#end of method
		jr $ra
	
	
	
	
	
	
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
