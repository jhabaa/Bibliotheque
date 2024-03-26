import csv
import mysql.connector
import uuid
# Connect to database
cnx = mysql.connector.connect(user='root', password='hean2000',
                                host='localhost',
                                database='bibliotheque')
cursor = cnx.cursor()

print("Connected to database")
# Fill books in database
csv_data = csv.reader(open('books.csv', encoding='utf-8'))
is_first_row = True
i = 0
for row in csv_data:
    if is_first_row:
        is_first_row = False
        continue
    if i > 1200:
        break
    idres = str(uuid.uuid4()).split('-')[0]
    titre = row[11].replace("'", "''")
    author = row[0].replace("'", "''")
    pages = int(row[8])
    description = row[2].replace("'", "''").replace('"', "''")
    rubrique = row[3].replace("'", "''")
    image = row[4]
    etat = row[9]
    print(f"INSERT INTO `ressource`(`idres`, `titre`, `auteur`, `nbrepages`, `resume`, `rubrique`, `image`, `etat`) VALUES('{i}','{titre}','{author}','{pages}','{description}','{rubrique}','image','{etat}')")
    cursor.execute(f"INSERT INTO `ressource`(`idres`, `titre`, `auteur`, `nbrepages`, `resume`, `rubrique`, `image`, `etat`) VALUES('{i}','{titre}','{author}','{pages}','{description}','{rubrique}','{image}','{etat}')")
    
    i+=1

cnx.commit()
cursor.close()