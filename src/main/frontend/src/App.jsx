import './App.css'
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home.jsx";
import BoardListContainer from "./containers/BoardListContainer.jsx";
import BoardReadContainer from "./containers/BoardReadContainer.jsx";
import BoardInsertContainer from "./containers/BoardInsertContainer.jsx";
import BoardUpdateContainer from "./containers/BoardUpdateContainer.jsx";

function App() {

  return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={ <Home /> } />
                <Route path="/boards" element={ <BoardListContainer /> } />
                <Route path="/boards/:no" element={ <BoardReadContainer /> } />
                <Route path="/boards/insert" element={ <BoardInsertContainer /> } />
                <Route path="/boards/update/:no" element={ <BoardUpdateContainer /> } />
            </Routes>
        </BrowserRouter>
    </>
  )
}

export default App
