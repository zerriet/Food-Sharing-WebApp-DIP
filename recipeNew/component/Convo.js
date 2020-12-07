
    // conversation object stored in separate variable:
    var convo = {
    // "ice" (as in "breaking the ice") is a required conversation object
    // that maps the first thing the bot will say to the user
    ice: {
    // "says" defines an array of sequential bubbles
    // that the bot will produce
    says: [
      "😁",
      "!",
      "Hello! I'm Foodie, your virtual assistant",
      "How can I help you?",
    ],
    // "reply" is an array of possible options the user can pick from
    // as a reply
    reply: [
      {
        question: "No, thanks.", // label for the reply option
        answer: "end" // key for an "escape valve"; we refer to this whenever a reply signals the end of the convo
      },
      {
        question: "Food facts!", // label for the reply option
        answer: "chapter-one" // key for the next conversation object
      },
      {
        question: "Help to book class", // label for the reply option
        answer: "chapter-five" // key for the next conversation object
      },
      
     
    ]
    }, // end required "ice" conversation object



    // main conversation trunk
    "chapter-one": {
    says: [
      "Do you know that",
      "Bananas have a total of 89 calories per 100 grams.",
      "Banana or Banana Split?",
      "Which do you prefer best?"
    ],
    reply: [
      {
        question: "Just Banana!",
        answer: "chapter-two" // here both replies send people onto the same next chapter
      },
      {
        question: "Banana Split!", // both replies send people onto the same next chapter
        answer: "chapter-three"
      },
    ]
   },
   "chapter-two": {
    says: [
  
      "<img src=https://media.giphy.com/media/1uPiL9Amv5zkk/giphy.gif />",
      
    ],
    reply: [
      
      {
        question: "End the chat.",
        answer: "end" // an example of using the Escape Valve for ineligible, Not Applicable participants
      }
    ]
  },

  // this chapter is skipped
  "chapter-three": {
    // we skip this in this example to show you can do that; use it if you want.
    says: [
      "<img src=https://media.giphy.com/media/DbxLbREJjfGA8/giphy.gif />",
    ],
    reply: [
      
      {
        question: "End the chat.",
        answer: "end" // an example of using the Escape Valve for ineligible, Not Applicable participants
      }
      
    ]
  },

  
  "chapter-five": {
    says: [
      "This will bring you to booking of classes.", // call a function to an external resource / application outside of chat-bubble's purview
      
    ],
    reply: [
      {
        question: "Not interested.",
        answer: "end"
      },
      {
        question: "Yes!",
        answer: "externalResourceFunction" // function name that will be executed
      }
    ]
  },
  end: {
    says: [
      "Thanks for your time!",
      
    ],
    reply: [
      {
        question: "Start over 😁",
        answer: "ice"
      }
    ]
  }
} // end conversation object

// initialize by constructing a named function...
var chatWindow = new Bubbles(
  document.getElementById("chat"), // ...passing HTML container element...
  "chatWindow" // ...and name of the function as a parameter
)

// `.talk()` will get your bot to begin the conversation
chatWindow.talk(
  // pass your JSON/JavaScript object to `.talk()` function where
  // you define how the conversation between the bot and user will go
  convo
)

// this function is called when user clicks "Yes!" in the "chapter-four" dialogue
externalResourceFunction = function() {
  // together with the function we'll restart the conversation starting from "capther-four"
  // to make sure the user isn't left hanging after the function below has been executed
  chatWindow.talk(convo, "chapter-five")

  // function that opens external window
  window.open(
    "classUser.html",
    "_blank",
    "toolbar=no,scrollbars=no,menubar=no,resizable=no,location=no,titlebar=no,width=1700, height=800"
  )
}
