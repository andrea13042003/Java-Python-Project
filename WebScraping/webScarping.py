import requests
from bs4 import BeautifulSoup
import pandas as pd

# Step 1: Send a request to the website
url = 'https://example.com/data'
response = requests.get(url)

# Step 2: Parse the HTML content
soup = BeautifulSoup(response.content, 'html.parser')

# Step 3: Find the target data
data = []
for item in soup.find_all('div', class_='target-class'):
    title = item.find('h2').text
    description = item.find('p').text
    data.append({'title': title, 'description': description})

# Step 4: Create a DataFrame
df = pd.DataFrame(data)

# Step 5: Save the data in a CSV file
df.to_csv('scraped_data.csv', index=False)
print('Data saved to scraped_data.csv')
