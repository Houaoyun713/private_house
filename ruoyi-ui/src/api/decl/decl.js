import request from '@/utils/request'

// 查询项目申报书列表
export function listDecl(query) {
  return request({
    url: '/decl/decl/list',
    method: 'get',
    params: query
  })
}

// 查询项目申报书详细
export function getDecl(id) {
  return request({
    url: '/decl/decl/' + id,
    method: 'get'
  })
}

// 新增项目申报书
export function addDecl(data) {
  return request({
    url: '/decl/decl',
    method: 'post',
    data: data
  })
}

// 修改项目申报书
export function updateDecl(data) {
  return request({
    url: '/decl/decl',
    method: 'put',
    data: data
  })
}

// 删除项目申报书
export function delDecl(id) {
  return request({
    url: '/decl/decl/' + id,
    method: 'delete'
  })
}
