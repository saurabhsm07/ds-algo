def validate_insert(board, curr_row_loc, curr_col_loc, curr_val):
    # Check row constraint
    for i in range(9):
        if board[curr_row_loc][i] == curr_val:
            return False

    # Check column constraint
    for i in range(9):
        if board[i][curr_col_loc] == curr_val:
            return False

    # Check 3x3 sub-grid constraint
    subgrid_row = (curr_row_loc // 3) * 3
    subgrid_col = (curr_col_loc // 3) * 3
    for i in range(3):
        for j in range(3):
            if board[subgrid_row + i][subgrid_col + j] == curr_val:
                return False

    return True


def if_solved(sudoku_chart):
    for i in range(0, 9):
        for j in range(0, 9):
            if sudoku_chart[i][j] == 0:
                return False

    return True


def print_sudoku_board(board):
    for i in range(0, len(board)):
        print(sudoku_board[i])


def make_sudoku_entry(i, j, sudoku_chart, val, operation_stack):
    sudoku_chart[i][j] = val
    operation_stack.append((i, j))
    print(f'INSERTED {val} at position {i},{j}')


def reset_sudoku_entry(sudoku_chart, operation_stack):
    if len(operation_stack) > 0:
        last_updated_obj = operation_stack.pop()
        print(
            f'RESET {sudoku_chart[last_updated_obj[0]][last_updated_obj[1]]} at position '
            f'{last_updated_obj[0]},{last_updated_obj[1]} to 0')
        sudoku_chart[last_updated_obj[0]][last_updated_obj[1]] = 0
    else:
        print('STARTING from the start')


def solve_sudoku(sudoku_chart):
    operation_stack = []

    def recursive_solver():
        if if_solved(sudoku_chart):
            return True

        for i in range(0, 9):
            for j in range(0, 9):
                if sudoku_chart[i][j] == 0:
                    for val in range(1, 10):
                        if validate_insert(sudoku_chart, i, j, val):
                            make_sudoku_entry(i, j, sudoku_chart, val, operation_stack)
                            print_sudoku_board(sudoku_chart)
                            if recursive_solver():
                                return True
                            reset_sudoku_entry(sudoku_chart, operation_stack)
                        print_sudoku_board(sudoku_chart)

        return False

    return recursive_solver()


sudoku_board = [
    [5, 3, 0, 0, 7, 0, 0, 0, 0],
    [6, 0, 0, 1, 9, 5, 0, 0, 0],
    [0, 9, 8, 0, 0, 0, 0, 6, 0],
    [8, 0, 0, 0, 6, 0, 0, 0, 3],
    [4, 0, 0, 8, 0, 3, 0, 0, 1],
    [7, 0, 0, 0, 2, 0, 0, 0, 6],
    [0, 6, 0, 0, 0, 0, 2, 8, 0],
    [0, 0, 0, 4, 1, 9, 0, 0, 5],
    [0, 0, 0, 0, 8, 0, 0, 7, 9]
]

result = solve_sudoku(sudoku_board)

if result:
    print("Solved successfully")
else:
    print("Unable to solve")

print_sudoku_board(sudoku_board)
