# XharkTank
A simple backend where pitchers can pitch their ideas to investors.

SharkTank is a panel of potential investors, termed as "Sharks", who listen to entrepreneurs pitch ideas for a business or product they wish to develop. These self-made multi-millionaires judge the business concepts and products pitched and then decide whether to invest their own money to help market and mentor each contestant.

📌These are the mandatory product flows that are expected while building the backend for the XharkTank application

➡️ 1) Entrepreneurs will post Pitch by providing these inputs

a) Name of the entrepreneur posting the pitch

b) Title of the pitch

c) Business Idea for the Product they wish to develop

d) Ask Expected Amount for investment

e) Percentage of Equity to be diluted

f) Investors will view all the latest pitches posted to date

g) If the entrepreneurs post a new pitch, that will also get listed. These submitted pitches will be shown one below the other.


➡️ 2) Investors will make a counteroffer to the pitch by providing these inputs

a) Unique Id of the Pitch made by the entrepreneur

b) Name of the investor making a counteroffer

c) Amount ready to invest in the idea

d) Ask Percentage of Equity for a company


📌Mandatory API Requirements
The interaction between the frontend and backend shall be based on a REST API with support for the below 4 endpoints.

1) Endpoint to post a pitch to the backend
2) Endpoint to make a counter offer for a pitch to the backend
3) Endpoint to fetch the all the pitches in the reverse chronological order ( i.e. last created one first ) from the backend
4) Endpoint to specify a particular id (identifying the pitch) to fetch a single Pitch.

