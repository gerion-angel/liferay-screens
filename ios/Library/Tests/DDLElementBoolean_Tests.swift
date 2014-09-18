/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
import XCTest


class DDLElementBoolean_Tests: XCTestCase {

	let parser:DDLParser = DDLParser(locale:NSLocale(localeIdentifier: "es_ES"))

	override func setUp() {
		super.setUp()
	}

	override func tearDown() {
		super.tearDown()
	}

	func test_Parse_ShouldExtractValues() {
		parser.xml =
			"<root available-locales=\"en_US\" default-locale=\"en_US\"> " +
			"<dynamic-element dataType=\"boolean\" " +
				"indexType=\"keyword\" " +
				"name=\"A_Boolean\" " +
				"readOnly=\"false\" " +
				"repeatable=\"true\" " +
				"required=\"false\" " +
				"showLabel=\"true\" " +
				"type=\"checkbox\" " +
				"width=\"\"> " +
					"<meta-data locale=\"en_US\"> " +
						"<entry name=\"label\">" +
							"<![CDATA[A Boolean]]>" +
						"</entry> " +
						"<entry name=\"predefinedValue\"> " +
							"<![CDATA[true]]> " +
						"</entry> " +
						"<entry name=\"tip\">" +
							"<![CDATA[The tip]]>" +
						"</entry> " +
					"</meta-data> " +
			"</dynamic-element> </root>"

		let elements = parser.parse()

		XCTAssertTrue(elements != nil)
		XCTAssertEqual(1, elements!.count)
		XCTAssertTrue(elements![0] is DDLElementBoolean)

		let booleanElement = elements![0] as DDLElementBoolean

		XCTAssertEqual(DDLElementDataType.DDLBoolean, booleanElement.dataType)
		XCTAssertEqual(DDLElementEditor.Checkbox, booleanElement.editorType)
		XCTAssertEqual("A_Boolean", booleanElement.name)
		XCTAssertEqual("A Boolean", booleanElement.label)
		XCTAssertEqual("The tip", booleanElement.tip)
		XCTAssertTrue(booleanElement.predefinedValue is Bool)
		XCTAssertTrue(booleanElement.predefinedValue as Bool)
		XCTAssertFalse(booleanElement.readOnly)
		XCTAssertTrue(booleanElement.repeatable)
		XCTAssertFalse(booleanElement.required)
		XCTAssertTrue(booleanElement.showLabel)
	}

	func test_Validate_ShouldFail_WhenRequiredValueIsNil() {
		parser.xml =
			"<root available-locales=\"en_US\" default-locale=\"en_US\"> " +
				"<dynamic-element dataType=\"boolean\" " +
						"name=\"A_Boolean\" " +
						"readOnly=\"false\" " +
						"repeatable=\"true\" " +
						"required=\"true\" " +
						"showLabel=\"true\" " +
						"type=\"checkbox\"> " +
					"<meta-data locale=\"en_US\"> " +
						"<entry name=\"label\"><![CDATA[A Boolean]]></entry> " +
					"</meta-data> " +
				"</dynamic-element> </root>"

		let elements = parser.parse()

		let booleanElement = elements![0] as DDLElementBoolean

		XCTAssertTrue(booleanElement.currentValue == nil)

		XCTAssertFalse(booleanElement.validate())
	}

}