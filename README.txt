Design 2 test running time: 12.039680891                                            
Design 3 test running time: 12.37826562                                                                               
Design 6 test running time: 12.28627359                                                                                
Design 2 getX() method time: 1.2686392966637379                                                                         
Design 3 getX() method time: 0.0                                                                                        
Design 6 getX() method time: 0.0                                                                                                                                                                                                                
Design 2 getY() method time: 0.024196808200360312                                                                       
Design 3 getY() method time: 0.025322987650369843                                                                       
Design 6 getY() method time: 0.024999570150372376                                                                                                                                                                                           
Design 2 getRho() method time: 0.0021508242500022597                                                                    
Design 3 getRho() method time: 0.0021878231000023486                                                                    
Design 6 getRho() method time: 0.00218494795000233                                                                                                                                                                                              
Design 2 getTheta() method time: 0.002118884950002208                                                                   
Design 3 getTheta() method time: 0.002167359350002268                                                                   
Design 6 getTheta() method time: 0.0021562476000022866                                                                                                                                                                                          
Design 2 convertStorageToPolar() method time: 0.0021279131500022185                                                     
Design 3 convertStorageToPolar() method time: 0.002168650050002265                                                      
Design 6 convertStorageToPolar() method time: 0.002161831400002308                                                                                                                                                                              
Design 2 convertStorageToCartesian() method time: 0.04254498375037021                                                   
Design 3 convertStorageToCartesian() method time: 0.04383340530038668                                                  
Design 6 convertStorageToCartesian() method time: 0.04336187580037415                                                                                                                                                                           
Design 2 getDistance() method time: 0.08110679879988278                                                                 
Design 3 getDistance() method time: 0.08370662889987587                                                                 
Design 6 getDistance() method time: 0.08273697284986446                                                                                                                                                                                         
Design 2 rotatePoint() method time: 0.40316893909976587                                                                 
Design 3 rotatePoint() method time: 0.41415286389972616                                                               
Design 6 rotatePoint() method time: 0.4116228218497454                                                                                                                                                                                          
Total Running Time: 12.28627359                                                                                         
Total Memory Used: 241696768 

we run the test with 2000000 instances for 20 calls for each 10 times times.
for each running time methods we initiated 20 calls of random variables then updates the maximum as well as minimum runtimes.

Design 3 takes more times to run than design 2 since it takes java to initiate Math class which results in longer runtime.

With design 6 user can use as both design 2 and 3 one at a time which make user can decide between and don't force them to have only one option.
the Disadvatages of Design 6 is an interface so you have to implements and modify other class to fit and keep the system run as usual. 

After we do the test, It's easy conclude that by an instance of Design 6 you can create design 2 or 3 for proficiency Or either design 2 or 3 for time efficiency.
depend on the purpose of users we can determine which design we should go for. since with design 6 we dont need to create conversion between Polar and Cartesian.






