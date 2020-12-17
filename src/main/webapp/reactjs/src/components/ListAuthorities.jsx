import React, { Component } from 'react';
import AuthorityService from '../services/AuthorityService';
import styled from 'styled-components';


const Heading = styled.h1`
    color: red;
    text-align: center;
`;

const MyBtn = styled.button`
display:inline-block;
 padding:0.7em 1.7em;
 margin:0 0.3em 0.3em 0;
 border-radius:0.2em;
 box-sizing: border-box;
 text-decoration:none;
 font-family:'Consolas',sans-serif;
 font-size: 12px;
 font-weight:400;
 color:#FFFFFF;
 background-color:#202025;
 box-shadow:inset 0 -0.6em 1em -0.35em rgba(0,0,0,0.17),inset 0 0.6em 2em -0.3em rgba(255,255,255,0.15),inset 0 0 0em 0.05em rgba(255,255,255,0.12);
 text-align:center;
 position:relative;
`;

const rowTr = styled.tr`
    backgroundColor : '#f4f4f4';
    border-color : black;
`;

const rowTd = styled.td`
    backgroundColor : '#f4f4f4';
    border-color : black;
`;


class ListAuthorities extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authorities: []
        }

    }

//       res = reslult , getting the data from the api
     componentDidMount(){
        AuthorityService.getAuthorities()
            .then((res) => {
                this.setState({authorities: res.data});
            });
     }

//render, produce output
    render() {
        //setting the class field variables to use them in render
        var { authorities } = this.state;

        return (
           <div>
                <Heading className="text-center">Authorities List</Heading>
                <tbody>
                    {
                        authorities.map(
                            authority =>
                            // <div style={{backgroundColor : '#202020'}}>
                            <tr key= {authority.userName}>
                                <rowTd> { authority.userName} </rowTd>
                                <rowTd style={{backgroundColor : '#f4f4f4'}}> { authority.authority} </rowTd>
                                <MyBtn> delete </MyBtn>
                            </tr>
                            // </div>

                        )
                    }
                </tbody>

           </div>
        );
    }
}

export default ListAuthorities;
