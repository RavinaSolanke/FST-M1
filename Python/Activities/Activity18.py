import pandas

dataframe = pandas.read_csv("sample.csv")
print("Full Data: ")
print(dataframe)

print("===============")
print("Usernames: ")
print(dataframe["Usernames"])

print("=============")
print("Username: ", dataframe["Username"][1], "I", "Password: ", dataframe["Username"][1])
print("======================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))
print("=====================")
print("Data sorted in descending order")
print(dataframe.sort_values('Passwords', ascending=False))



