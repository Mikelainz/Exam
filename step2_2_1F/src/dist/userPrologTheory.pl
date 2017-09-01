rotationSpeedRight(100).
rotationSpeedLeft(100).
forwardSpeed(100).
rotationTimeRight(230).
rotationTimeLeft(230).
searchTimeForward(1500).
senseTimeFixedObstacle(2500).
finalPointTollerance(10).

rotationRightValues(SPEED, TIME):-rotationSpeedRight(SPEED), rotationTimeRight(TIME).
rotationLeftValues(SPEED, TIME):-rotationSpeedLeft(SPEED), rotationTimeLeft(TIME).
searchForwardValues(SPEED, TIME):-forwardSpeed(SPEED), searchTimeForward(TIME).
deadEndForwardValues(SPEED, TIME):-forwardSpeed(SPEED), retract(actopOpDone(OP, TIME)).

path([]).
pathEmpty:-path([]).

saveMove(fwd):-retract(actorOpDone(OP, TIME)), retract(path(L)), assert(path([[fwd, TIME] | L])).
saveMove(rgt):-rotationTimeRight(TIME), retract(path(L)), assert(path([[rgt, TIME] | L])).
saveMove(lft):-rotationTimeLeft(TIME), retract(path(L)), assert(path([[lft, TIME] | L])).

nextMove(fwd, SPEED, TIME):-path([[fwd, TIME] | LT]), forwardSpeed(SPEED), retract(path(L)), assert(path(LT)).
nextMove(rgt, SPEED, TIME):-path([[rgt, TIME] | LT]), rotationSpeedRight(SPEED), retract(path(L)), assert(path(LT)).
nextMove(lft, SPEED, TIME):-path([[LFT, TIME] | LT]), rotationSpeedLeft(SPEED), retract(path(L)), assert(path(LT)).