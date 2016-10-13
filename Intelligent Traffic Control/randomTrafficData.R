nodesInput <- floor(rnorm(44, mean = 50, sd = 30))
for(i in 1:44) {
    if(nodesInput[i] < 0)
        nodesInput[i] <- 0;
}
nodesInputMatrix <- matrix(data = nodesInput, nrow = 11, ncol = 4, byrow = TRUE)
nodesOutput <- vector(mode = "numeric", length = 120)
error <- 0
for(i in 1:40) {
    left <- floor(runif(1, min=0, max=nodesInput[i]))
    if(left < 0)
        error <- error + 1
    
    straight <- floor(runif(1, min=0, max=(nodesInput[i] - left)))
    if(straight < 0)
        error <- error + 1
    
    right <- nodesInput[i] - left - straight;
    if(right < 0)
        error <- error + 1
    
    if((left + straight + right) != nodesInput[i])
        error <- error + 1
    
    j <- 3*(i-1)
    nodesOutput[(j+1)] <- left
    nodesOutput[(j+2)] <- straight
    nodesOutput[(j+3)] <- right
}
nodesOutputMatrix <- matrix(data = nodesOutput, nrow = 40, ncol = 3, byrow = TRUE)

crossCheck <- vector(mode = "numeric", length = 40)
error1 <- 0
for(i in 1:40) {
    crossCheck[i] <- sum(nodesOutputMatrix[i,])
    if(crossCheck[i] != nodesInput[i])
        error1 <- error1 + 1
}
