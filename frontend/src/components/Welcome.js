import React, { Component } from 'react'
import { Jumbotron } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import BookmarkAPI from '../services/BookmarkService';

export default class Welcome extends Component {

	state = {
		message: 'data is not imported'
	}

	extractAllBookmarks = () => {

		BookmarkAPI.extractAllBookmarks().then(result => {

			console.log(result);
			if (result && result.status === 200) {
				this.setState({

					message: 'Data insertion '+result.data
				})

			} else {
				this.setState({
					message: 'Data insertion '+result.data
				})
			}

		}
		)

	};

	render() {
		let { message } = this.state;
		return (
			<>
				<Jumbotron className="bg-dark text-white">
					<h1>Welcome!</h1>
					<p>
						You are logged in
					</p>
				</Jumbotron>
				<Jumbotron className="bg-dark text-white">
				
					<p>
						{message}
					</p>
				</Jumbotron>
				<Button size="sm" variant="success" type="button" onClick={() => this.extractAllBookmarks()}>
					Loding Data
				</Button>
			</>
		)
	}
}