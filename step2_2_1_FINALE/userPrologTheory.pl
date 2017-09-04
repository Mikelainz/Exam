rotationSpeedRight(80).
rotationSpeedLeft(80).
forwardSpeed(30).
rotationTimeRight(345).
rotationTimeLeft(345).
searchTimeForward(1500).
senseTimeFixedObstacle(2500).

rotationRightValues(SPEED, TIME):-rotationSpeedRight(SPEED), rotationTimeRight(TIME).
rotationLeftValues(SPEED, TIME):-rotationSpeedLeft(SPEED), rotationTimeLeft(TIME).
searchForwardValues(SPEED, TIME):-forwardSpeed(SPEED), searchTimeForward(TIME).
deadEndForwardValues(SPEED, TIME):-forwardSpeed(SPEED), retract(attemptRightTotalTime(TIME)).

path([]).
pathEmpty:-path([]).

saveMove(fwd):-retract(actorOpDone(OP, TIME)), retract(path(L)), assert(path([[fwd, TIME] | L])).
saveMove(rgt):-rotationTimeRight(TIME), retract(path(L)), assert(path([[rgt, TIME] | L])).
saveMove(lft):-rotationTimeLeft(TIME), retract(path(L)), assert(path([[lft, TIME] | L])).

isNextMove(fwd, SPEED, TIME):-path([[fwd, TIME ] | _ ]), forwardSpeed(SPEED).
isNextMove(rgt, SPEED, TIME):-path([[rgt, TIME] | LT]), rotationSpeedLeft(SPEED).
isNextMove(lft, SPEED, TIME):-path([[lft, TIME] | LT]), rotationSpeedRight(SPEED).

deleteLastMove(MOVE) :- path([ MOVE | LT]), retract(path(L)), assert(path(LT)).

clearPath(LOUT):-retract(path(L)), deleteOppositeRightLeftIfPresent(L, LOUT), assert(path(LOUT)).

deleteOppositeRightLeftIfPresent(LIN, LOUT):-checkPresent(LIN), !, deleteOppositeRightLeft(LIN, LTEMP), deleteOppositeRightLeftIfPresent(LTEMP, LOUT).
deleteOppositeRightLeftIfPresent(LIN, LIN).

checkPresent([[rgt, _ ], [lft, _ ] | LT]):-!.
checkPresent([[lft, _ ], [rgt, _ ] | LT]):-!.
checkPresent([ MOVE | LT]):-checkPresent(LT).

deleteOppositeRightLeft([], []).
deleteOppositeRightLeft([ MOVE ], [ MOVE ]).
deleteOppositeRightLeft([[rgt, _ ], [lft, _ ] | LT], LOUT):-!, deleteOppositeRightLeft(LT, LOUT).
deleteOppositeRightLeft([[lft, _ ], [rgt, _ ] | LT], LOUT):-!, deleteOppositeRightLeft(LT, LOUT).
deleteOppositeRightLeft([ MOVE | LT], [ MOVE | LTOUT ]):-deleteOppositeRightLeft(LT, LTOUT).