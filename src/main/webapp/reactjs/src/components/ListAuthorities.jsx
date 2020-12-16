import React, { Component } from 'react'
import AuthorityService from '../services/AuthorityService'

class ListAuthorities extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authorities: []
        }

    }

     componentDidMount(){
        AuthorityService.getAuthorities().then((res) => {
            this.setState({authorities: res.data});
        });
     }

    render() {
        return (
           <div>
                <h2 className="text-center">Authorities List</h2>
                <tbody>
                    {
                        this.state.authorities.map(
                            authority =>
                            <tr key= {authority.userName}>
                                <td> { authority.userName} </td>
                                <td> { authority.authority} </td>
                                <button>x</button>
                            </tr>

                        )
                    }
                </tbody>

           </div>
        );
    }
}

export default ListAuthorities;