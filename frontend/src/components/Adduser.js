import React, { Component } from 'react'
import { Card, Form, Button, Col } from 'react-bootstrap'
import BookmarkAPI from '../services/BookmarkService'

export default class Adduser extends Component {

	constructor(props) {
		super(props);
		this.state = { role: 'USER', bookmark:null };
		this.userChange = this.userChange.bind(this);
		this.submitUser = this.submitUser.bind(this);

		
		
	}

	componentDidMount(){
		console.log(this.props.location.state.data)
		this.setState({
			bookmark:this.props.location.state.data
		})
	}

	submitUser(event) {
		event.preventDefault();

		const bookmark = {
			bookmarkId:this.state.bookmark.id,
			name: this.state.bookmark.name,
			url: this.state.bookmark.url,
			description: this.state.bookmark.description

		};
		BookmarkAPI.updateBookmark(bookmark).then(result => {
			if (result.status === 200) {
				this.props.history.push("/bookmarks");
			}
		})


	}

	userChange(event) {

		console.log(event.target.name)
		let bookmarkNew = this.state.bookmark;
		bookmarkNew[event.target.name] = event.target.value;
		this.setState({
			bookmark: bookmarkNew
		});
	}

	render() {
		let {bookmark}= this.state;
		return (
			<Card className={"border border-dark bg-dark text-white"}>
				<Card.Header>Bookmarks</Card.Header>
				<Form onSubmit={this.submitUser} id="bookFormId">
					{bookmark &&
					<Card.Body>
						<Form.Row>
							<Form.Group as={Col} controlId="formGridTitle">
								<Form.Label>Name</Form.Label>
								<Form.Control required
									type="text" name="name"
									value={bookmark.name}
									onChange={this.userChange}
									className={"bg-dark text-white"}
									 />
							</Form.Group>
						</Form.Row>
						<Form.Row>
							<Form.Group as={Col} controlId="formGridTitle">
								<Form.Label>URL</Form.Label>
								<Form.Control required
									type="text" name="url"
									value={bookmark.url}
									onChange={this.userChange}
									className={"bg-dark text-white"}
									 />
							</Form.Group>
						</Form.Row>
						<Form.Row>
							<Form.Group as={Col} controlId="formGridTitle">
								<Form.Label>Description</Form.Label>
								<Form.Control required
									type="text" name="description"
									value={bookmark.description}
									onChange={this.userChange}
									className={"bg-dark text-white"}
								 />
							</Form.Group>
						</Form.Row>
						
					</Card.Body>
					}<></>
					<Card.Footer style={{ "textAlign": "right" }}>
						<Button size="sm" variant="success" type="submit">
							Update
						</Button>
					</Card.Footer>
				</Form>
			</Card>
		);
	}
}