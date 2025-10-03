def get_nth_row(n):
    """
    Return the Nth row of Pascal's triangle (0-indexed)
    """
    if n < 0:
        return []
    
    row = [1]
    for k in range(1, n + 1):
        element = row[k - 1] * (n - k + 1) // k
        row.append(element)
    
    return row

def main():
    try:
        N = int(input("Enter the row number N (0-indexed): "))
        
        if N < 0:
            print("Please enter a non-negative integer.")
            return
        
        result = get_nth_row(N)
        print(f"Row {N} of Pascal's triangle: {result}")
        
        # Optional: Display the triangle up to row N
        print(f"\nPascal's triangle up to row {N}:")
        for i in range(N + 1):
            print(f"Row {i}: {get_nth_row(i)}")
            
    except ValueError:
        print("Please enter a valid integer.")

if __name__ == "__main__":
    main()
