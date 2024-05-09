import pandas

data = {
    "Usernames" : ["admin", "Charles","Deku"],
    "Password" : ["password","Charll3", "AllMight"]
}
dataframe = pandas.DataFrame(data)
print(dataframe)
dataframe.to_csv("sample.csv", index=False)