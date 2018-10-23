// Generated from gram.g4 by ANTLR 4.7.1
package database;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramParser}.
 */
public interface gramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(gramParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(gramParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(gramParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(gramParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(gramParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(gramParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(gramParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(gramParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#open_cmd}.
	 * @param ctx the parse tree
	 */
	void enterOpen_cmd(gramParser.Open_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#open_cmd}.
	 * @param ctx the parse tree
	 */
	void exitOpen_cmd(gramParser.Open_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#close_cmd}.
	 * @param ctx the parse tree
	 */
	void enterClose_cmd(gramParser.Close_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#close_cmd}.
	 * @param ctx the parse tree
	 */
	void exitClose_cmd(gramParser.Close_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void enterWrite_cmd(gramParser.Write_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void exitWrite_cmd(gramParser.Write_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#exit_cmd}.
	 * @param ctx the parse tree
	 */
	void enterExit_cmd(gramParser.Exit_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#exit_cmd}.
	 * @param ctx the parse tree
	 */
	void exitExit_cmd(gramParser.Exit_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#show_cmd}.
	 * @param ctx the parse tree
	 */
	void enterShow_cmd(gramParser.Show_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#show_cmd}.
	 * @param ctx the parse tree
	 */
	void exitShow_cmd(gramParser.Show_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#create_cmd}.
	 * @param ctx the parse tree
	 */
	void enterCreate_cmd(gramParser.Create_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#create_cmd}.
	 * @param ctx the parse tree
	 */
	void exitCreate_cmd(gramParser.Create_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#update_cmd}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_cmd(gramParser.Update_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#update_cmd}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_cmd(gramParser.Update_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#insert_cmd}.
	 * @param ctx the parse tree
	 */
	void enterInsert_cmd(gramParser.Insert_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#insert_cmd}.
	 * @param ctx the parse tree
	 */
	void exitInsert_cmd(gramParser.Insert_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#delete_cmd}.
	 * @param ctx the parse tree
	 */
	void enterDelete_cmd(gramParser.Delete_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#delete_cmd}.
	 * @param ctx the parse tree
	 */
	void exitDelete_cmd(gramParser.Delete_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(gramParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(gramParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#relation_name}.
	 * @param ctx the parse tree
	 */
	void enterRelation_name(gramParser.Relation_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#relation_name}.
	 * @param ctx the parse tree
	 */
	void exitRelation_name(gramParser.Relation_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(gramParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(gramParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(gramParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(gramParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(gramParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(gramParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_name(gramParser.Attribute_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_name(gramParser.Attribute_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#attribute_list}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_list(gramParser.Attribute_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#attribute_list}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_list(gramParser.Attribute_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(gramParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(gramParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#typed_attr_list}.
	 * @param ctx the parse tree
	 */
	void enterTyped_attr_list(gramParser.Typed_attr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#typed_attr_list}.
	 * @param ctx the parse tree
	 */
	void exitTyped_attr_list(gramParser.Typed_attr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(gramParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(gramParser.TypeContext ctx);
}