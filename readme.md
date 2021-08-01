# Barbershop Management Service

A barbershop consists of a waiting room with n chairs, and a barber chair for giving haircuts. If there are no customers to be served, the barber goes to sleep. If a customer enters the barbershop and all chairs are occupied, then the customer leaves the shop. If the barber is busy, but chairs are available, then the customer sits in one of the free chairs. If the barber is asleep, the customer wakes up the barber.  
The application coordinates the interaction between barbers and customers

[Documentation Link](https://docs.google.com/document/d/1A3F7NU3UjZPpfK9ws891XRsri9ssoMEMFHYZ0spsziI/edit?usp=sharing)

[Jar File Link](https://drive.google.com/file/d/1S4w-RfbqA554DKCGxCVdQwBCe8MEwaTT/view?usp=sharing)

#### Command to run Jar File
```
java -jar barberShop.jar
```

## Features
- Initialise barber shop with N seats
- Allocate seat to customer if seat available
- Instruct barber to cut hair in first-come-first-server basis
- Post hair cut, the seat becomes available for other customers
- Check status of barber : Sleeping (no customers) or Active

## Data Structure
The seats are represented as a boolean array
```
boolean[] seats = new boolean[N]
```

Here `N` is the number of seats in the barber shop.

if 	`seats[i] == true` this implies the seat is occupied by a customer, else the seat is not occupied.  

There are two pointers, `seatPointer` and `barberPointer`.

The *seatPointer* points to the index, where the next customer will be allocated a seat if available.  
The *barberPointer* points to the index, where the barber next needs to provide his/her service.  

Both *seatPointer* and *barberPointer* are initialised at position 0.  
The pointers move from left to right in the *seats* array, in a circular manner. Once the pointer reaches the end, it starts again from the front (at index 0).  

## Algorithm

### Allocate Seat
if `seats[seatPointer % N] == false`,   
&nbsp;&nbsp;&nbsp;&nbsp;then allocate seat, ie. mark `seats[seatPointer % N] = true` and increment seatPointer, ie `seatPointer++`  
else  
&nbsp;&nbsp;&nbsp;&nbsp;print seat cannot be allocated.  

**Time complexity:** O(1). 

### Cut Hair
if `seats[barberPointer % N] == true`  
&nbsp;&nbsp;&nbsp;&nbsp;Then cut hair, ie. mark `seats[barberPointer % N]=false` and increment barberPointer, ie. `barberPointer++`.   
else  
&nbsp;&nbsp;&nbsp;&nbsp;print seat is empty, hence no hair cut.  

**Time complexity:** O(1). 

### Check Barber Status
if `barberPointer == seatPointer && seats[barberPoiner % N] == false`  
&nbsp;&nbsp;&nbsp;&nbsp;then this means no customer is available, barber is in sleep state.    
else  
&nbsp;&nbsp;&nbsp;&nbsp;Barber has customer(s) to serve. Barber is in active state.  

**Time complexity:** O(1). 

## Commands
`allocate seat` : To allocate a seat to customer.   
`cut hair` : To instruct barber to cut hair in barber's current position.    
`check status` : To check if barber is sleeping or active.  
`exit`: To terminate the application.  

## Sample commands and output
```
Barber shop management com.rccode.service started, please enter number of seats... or Enter -1 to terminate application
3

Barber shop init completed, please enter commands...

allocate seat
Seat allocated

allocate seat
Seat allocated

barber status
Barber is active

cut hair
Hair cut done

allocate seat
Seat allocated

allocate seat
Seat allocated

allocate seat
Shop is full, seat cannot be allocated

cut hair
Hair cut done

cut hair
Hair cut done

cut hair
Hair cut done

cut hair
No customer, barber sleeping

barber status
Barber is sleeping

exit
Terminating barber shop management com.rccode.service
```
