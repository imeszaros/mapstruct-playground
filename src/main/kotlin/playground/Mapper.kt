package playground

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
abstract class Mapper {

  // ok
  abstract fun clone0(repository: Repository, commitComment: CommitComment, @Context cloneContext: CloneContext): CommitComment

  // ok
  abstract fun clone1(commitComment: CommitComment, repository: Repository, @Context cloneContext: CloneContext): CommitComment

  // nah, i would expect to use mapIssueNumber()
  @Mapping(target = "issueId", qualifiedBy = [Mapped::class])
  abstract fun clone2(commitComment: CommitComment, repository: Repository, @Context cloneContext: CloneContext): CommitComment

  // it works if i remove the second argument
  @Mapping(target = "issueId", qualifiedBy = [Mapped::class])
  abstract fun clone3(commitComment: CommitComment, @Context cloneContext: CloneContext): CommitComment

  // explicitly adding the source parameter also fixes it
  @Mapping(target = "issueId", source = "commitComment.issueId", qualifiedBy = [Mapped::class])
  abstract fun clone4(commitComment: CommitComment, repository: Repository, @Context cloneContext: CloneContext): CommitComment

  @Mapped
  fun mapIssueNumber(issueNumber: Int, @Context cloneContext: CloneContext) = cloneContext.issueNumberMapper(issueNumber)
}