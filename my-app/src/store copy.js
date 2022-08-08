//액션
export const increase = () => ({ type: "INCREMENT" });
export const decrease = () => ({ type: "DECREMENT" });

//상태
const initstate = {
    number: 0,
}


//액션의 결과를 걸러내는 친구
const reducer = (state = initstate, action) => {


    switch (action.type) {
        case "INCREMENT":
            return { number: state.number + 1 }; //return 되면 호출한 쪽에서 받는 것이 아니라 return 되는 순가 Ui 변경 

        case "DECREMENT":
            return { number: state.number - 1 };

        default:
            return state;
    }

}

export default reducer;



