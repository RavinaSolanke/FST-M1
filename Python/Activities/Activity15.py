try:
    print(x) # type: ignore
except NameError:
    print("x hasn't been defined yet.")