//액션
export const increase = (username) => ({ type: "INCREMENT", payload: username });
export const decrease = () => ({ type: "DECREMENT" });
export const dataInfo = (username) => ({ type: "DATAINFO", payload: username });

//상태
const initstate = {
    number: 1,
    hello: 8,
    username: 'ssar'
}


//액션의 결과를 걸러내는 친구
const rootReducer = (state = initstate, action) => {

    switch (action.type) {
        case "INCREMENT":
            return { number: state.number + 1, username: action.payload }; //return 되면 호출한 쪽에서 받는 것이 아니라 return 되는 순가 Ui 변경 

        case "DECREMENT":
            return { number: state.number - 1 };
        case "DATAINFO":
            return { username: state.username }
        default:
            return state;
    }
}

export default rootReducer;



