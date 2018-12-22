farmer = 0
fox = 0
goose = 0
beans = 0
is_win = False
is_survive = True


def win():
    win_cond0 = True
    win_cond1 = win_cond0 and fox == 1
    win_cond2 = win_cond1 and goose == 1
    win_cond3 = win_cond2 and beans == 1
    win_cond = win_cond3 and farmer == 1

    return win_cond


def survive():
    die_cond1 = fox == goose and farmer != fox
    die_cond2 = goose == beans and farmer != goose
    die_cond = die_cond1 or die_cond2
    servive_cond = not die_cond

    return servive_cond


def legal_move(move):
    result = True
    if move == 1 and farmer != fox:
        result = False

    if move == 2 and farmer != goose:
        result = False

    if move == 3 and farmer != beans:
        result = False

    return result


def cross(subject):
    result = 0

    if subject == 0:
        result = 1
    else:
        result = 0

    return result


def gen_action():
    move = nextr()  # 0-farmer alone, 1-fox, 2-goose, 3-beans
    legal = legal_move(move)

    while not legal:
        move = nextr()
        legal = legal_move(move)

    return move

i = 0
while i < 7:
    i = i + 1
    move = gen_action()

    farmer = cross(farmer)
    if move == 1:
        fox = cross(fox)
    if move == 2:
        goose = cross(goose)
    if move == 3:
        beans = cross(beans)

    is_win = win()
    is_survive = survive()

    # print "farmer=", farmer, ",fox=", fox, ",goose=", goose, ",beans=", beans