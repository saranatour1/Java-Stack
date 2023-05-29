from django.shortcuts import render ,redirect

# Create your views here.
from django.http import HttpResponse
from textblob import TextBlob


def index(request):
    num_visits = request.session.get('blob')
    
    context = {'h':num_visits}
    return render(request, "chat.html" , context=context)

def formInput(request):
    kIn = request.POST['thisInput']
    print(request.POST['thisInput'])
    blob = TextBlob(kIn)
    sentiment = blob.sentiment.polarity
    print(sentiment)
    request.session["blob"] = sentiment
    return redirect("/")



# # Define a sample text
# text = """I love this product.
# It is the best purchase 
# I have ever made."""
# text1='I will burn the world'
# text2='I hate the world'
# #text="hate the world"
# # Create a TextBlob object for the text
# blob = TextBlob(text2)

# # Perform sentiment analysis on the text
# sentiment = blob.sentiment.polarity

# # Print the sentiment score
# print(sentiment)





